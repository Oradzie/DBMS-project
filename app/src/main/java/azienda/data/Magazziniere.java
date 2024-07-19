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

        public List<String> showWarahouseStatistics(final Connection connection, final String codiceFiscale,final String codiceDipendente, final String nome, final String cognome){
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.SHOW_WAREHOUSE_STATISTICS, codiceDipendente,codiceFiscale,nome,cognome);
                    var resultSet = statement.executeQuery();
            ) {
                final List<String> warahouseStatistics = new ArrayList<String>();
                while (resultSet.next()) {
                    warahouseStatistics.addAll(List.of(resultSet.getString("CodiceDipendente")
                                                    ,resultSet.getString("CodiceFiscale")
                                                    ,resultSet.getString("Cognome")
                                                    ,resultSet.getString("Nome")));
                }
                return warahouseStatistics;
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
