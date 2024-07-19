package azienda.data;

import com.google.common.base.Optional;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.util.*;

import org.checkerframework.checker.units.qual.A;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

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

    public static class DAO {

        public static List<MyTableRow> showWarehouseStatistics(final Connection connection,
                final String codiceMagazzino) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.SHOW_WAREHOUSE_STATISTICS,
                            codiceMagazzino);
                    var resultSet = statement.executeQuery();) {
                final List<MyTableRow> warahouseStatistics = new ArrayList<MyTableRow>();
                while (resultSet.next()) {
                    warahouseStatistics.add(new MyTableRow(resultSet.getString("CodiceFiscale"),
                            resultSet.getString("CodiceDipendente"), resultSet.getString("Nome"),
                            resultSet.getString("Cognome"), resultSet.getInt("NumeroPacchiPreparati")));
                }
                return warahouseStatistics;
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static String addMagazziniere(final Connection connection, final String codiceFiscale,
                final String nome, final String cognome, final String telefono, final String codiceDipendente,
                final String codiceMagazzino, final String password, final String datiFatturazione) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.ADD_PERSONA_MAG,
                            nome, cognome, codiceFiscale, telefono);) {
                int result = statement.executeUpdate();
                if (result == 0) {
                    return "Errore nell'inserimento del magazziniere";
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                return "Persona già esistente";
            } catch (Exception e) {
                throw new DAOException(e);
            }

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.ADD_DIPENDENTE_MAG,
                            codiceFiscale, codiceDipendente, codiceMagazzino, password);) {
                int result = statement.executeUpdate();
                if (result == 0) {
                    return "Errore nell'inserimento del magazziniere";
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                return "Dipendente gia' esistente";
            } catch (Exception e) {
                throw new DAOException(e);
            }

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.ADD_MAGAZZINIERE,
                            codiceFiscale);) {
                int result = statement.executeUpdate();
                if (result != 0) {
                    return "Magazziniere inserito!";
                } else {
                    return "Errore nell'inserimento del magazziniere";
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                return "Magazziniere gia' esistente";
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }

    public static List<MagazziniereRow> showDatiMagazzinieri(final Connection connection,
    final String codiceMagazzino){
        try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.SHOW_WAREHOUSE_STATISTICS,
                            codiceMagazzino);
                    var resultSet = statement.executeQuery();) {
                final List<MagazziniereRow> datiMagazzinieri = new ArrayList<MagazziniereRow>();
                while (resultSet.next()) {
                    datiMagazzinieri.add(new MagazziniereRow(resultSet.getString("CodiceDipendente"),
                                                            resultSet.getString("Cognome"),
                                                            resultSet.getString("Nome"),
                                                            resultSet.getString("Telefono"),
                                                            resultSet.getString("IBAN"),
                                                            resultSet.getString("Via"),
                                                            resultSet.getInt("CAP"),
                                                            resultSet.getInt("NumCivico")));
                }
                return datiMagazzinieri;
            } catch (Exception e) {
                throw new DAOException(e);
            }
    }
}
