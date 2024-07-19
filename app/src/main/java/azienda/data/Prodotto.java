package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class Prodotto {

    public final String numeroSeriale;
    public final String codiceLotto;
    public final String codicePacco;
    public final String codiceProdotto;
    public final String codiceRipiano;

    public Prodotto(String numeroSeriale, String codiceLotto, String codicePacco, String codiceProdotto,
            String codiceRipiano) {
        this.numeroSeriale = numeroSeriale;
        this.codiceLotto = codiceLotto;
        this.codicePacco = codicePacco;
        this.codiceProdotto = codiceProdotto;
        this.codiceRipiano = codiceRipiano;
    }

    public String getNumeroSeriale() {
        return numeroSeriale;
    }

    public String getCodiceLotto() {
        return codiceLotto;
    }

    public String getCodicePacco() {
        return codicePacco;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }

    public String getCodiceRipiano() {
        return codiceRipiano;
    }

    public static final class DAO {

        public static List<Prodotto> list(final Connection connection) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.LIST_PRODUCTS);
                    var resultSet = statement.executeQuery();) {
                final List<Prodotto> products = new ArrayList<Prodotto>();

                while (resultSet.next()) {
                    final String numeroSeriale = resultSet.getString("NumeroSeriale");
                    final String codiceLotto = resultSet.getString("CodiceLotto");
                    final String codicePacco = resultSet.getString("CodPacco");
                    final String codiceProdotto = resultSet.getString("CodiceProdotto");
                    final String codiceRipiano = resultSet.getString("CodRipiano");
                    final Prodotto product = new Prodotto(numeroSeriale, codiceLotto, codicePacco, codiceProdotto,
                            codiceRipiano);
                    products.add(product);
                }

                return products;
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static String delProduct(final Connection connection, final String NumeroSeriale) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.DEL_PRODOTTO,
                            NumeroSeriale);) {
                int result = statement.executeUpdate();
                if (result == 0) {
                    return "Prodotto non trovato";
                }
                return "Prodotto eliminato con successo";
            } catch (SQLIntegrityConstraintViolationException e) {
                return "Prodotto non trovato";
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static String viewProduct(final Connection connection, final String CodiceProdotto) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.VIEW_PRODOTTO,
                            CodiceProdotto);
                    var resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return (resultSet.getString("Disponibilita"));
                } else {
                    return "Prodotto non trovato";
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static String addProduct(final Connection connection, final String NumeroSeriale,
                final String CodiceLotto, final String CodiceProdotto, final String CodRipiano) {

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_PRODUCT,
                            NumeroSeriale);
                    var resultSet = statement.executeQuery();) {
                if (resultSet.next()) {
                    return "Prodotto gia' nel database";
                }

            } catch (Exception e) {
                throw new DAOException(e);
            }

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_LOTTO,
                            CodiceLotto);
                    var resultSet = statement.executeQuery();) {

                if (!resultSet.next()) {
                    return "Lotto inserito non esistente";
                }

            } catch (Exception e) {
                throw new DAOException(e);
            }

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_VERSIONE_PRODOTTO,
                            CodiceProdotto);
                    var resultSet = statement.executeQuery();) {

                if (!resultSet.next()) {
                    return "Versione prodotto inserita non esistente";
                }

            } catch (Exception e) {
                throw new DAOException(e);
            }

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_RIPIANO,
                            CodRipiano);
                    var resultSet = statement.executeQuery();) {

                if (!resultSet.next()) {
                    return "Ripiano non esistente";
                }

            } catch (Exception e) {
                throw new DAOException(e);
            }

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.ADD_PRODUCT,
                            NumeroSeriale, CodiceLotto, CodiceProdotto, CodRipiano);) {
                int result = statement.executeUpdate();
                if (result != 0) {
                    return "Prodotto inserito!";
                } else {
                    return "Errore nell'inserimento del prodotto";
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                return "Prodotto gia' esistente";
            } catch (Exception e) {
                throw new DAOException(e);
            }

        }
    }
}
