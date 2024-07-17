package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class Dipendente extends Persona{

    public final String CodiceDipendente;
    public final String CodiceMagazzino;
    public final String Password;
    public DatiFatturazione datiFatturazione;
    

    public Dipendente(String nome, String cognome, String codiceFiscale, int telefono, String codiceDipendente,
            String codiceMagazzino, String password, DatiFatturazione datiFatturazione) {
        super(nome, cognome, codiceFiscale, telefono);
        CodiceDipendente = codiceDipendente;
        CodiceMagazzino = codiceMagazzino;
        Password = password;
        this.datiFatturazione = datiFatturazione;
    }

    public String getCodiceDipendente() {
        return CodiceDipendente;
    }

    public String getCodiceMagazzino() {
        return CodiceMagazzino;
    }

    public String getPassword() {
        return Password;
    }

    public DatiFatturazione getDatiFatturazione() {
        return datiFatturazione;
    }

    public void setDatiFatturazione(DatiFatturazione datiFatturazione) {
        this.datiFatturazione = datiFatturazione;
    }

    public static final class DAO {

        public static Optional<String> handleLogin(final Connection connection, final String codiceDipendente) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_DIPENDENTE, codiceDipendente);
                    var resultSet = statement.executeQuery();
            ) {
                if (resultSet.next()) {
                    return Optional.of(resultSet.getString("Password"));
                } else {
                    return Optional.empty();
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
