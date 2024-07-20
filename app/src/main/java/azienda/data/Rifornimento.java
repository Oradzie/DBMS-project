package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Rifornimento {

    public final String codiceRifornimento;
    public final String codiceFornitore;
    public final String codiceFiscale;

    public Rifornimento(String codiceRifornimento, String codiceFornitore, String codiceFiscale) {
        this.codiceRifornimento = codiceRifornimento;
        this.codiceFornitore = codiceFornitore;
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceRifornimento() {
        return codiceRifornimento;
    }

    public String getCodiceFornitore() {
        return codiceFornitore;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    public static final class DAO {

        public static boolean addRifornimento(final Connection connection, final String codiceFiscaleAmministratore, final Fornitore fornitore,
                                              final VersioneProdotto prodotto, final int quantity) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.ADD_RIFORNIMENTO,
                            fornitore.getCodiceFornitore(), codiceFiscaleAmministratore, quantity);) {
                int result = statement.executeUpdate();
                System.out.println("Rifornimento aggiunto: " + result);
                return result > 0;
            } catch (final Exception e) {
                throw new DAOException(e);
            }
        }
    }
}   
