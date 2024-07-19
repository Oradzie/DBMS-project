package azienda.data;

import com.google.common.base.Optional;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.util.*;

import org.checkerframework.checker.units.qual.A;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class Magazziniere {

    public String codiceFiscale;

    public Magazziniere(final String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(final String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public static class DAO{

        public static List<MyTableRow> showWarehouseStatistics(final Connection connection, final String codiceMagazzino){
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.SHOW_WAREHOUSE_STATISTICS,codiceMagazzino);
                    var resultSet = statement.executeQuery();
            ) {
                final List<MyTableRow> warahouseStatistics = new ArrayList<MyTableRow>();
                while (resultSet.next()) {
                    warahouseStatistics.add(new MyTableRow(resultSet.getString("CodiceFiscale")
                                                    ,resultSet.getString("CodiceDipendente")
                                                    ,resultSet.getString("Nome")
                                                    ,resultSet.getString("Cognome")
                                                    ,resultSet.getInt("NumeroPacchiPreparati")));
                }
                return warahouseStatistics;
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
