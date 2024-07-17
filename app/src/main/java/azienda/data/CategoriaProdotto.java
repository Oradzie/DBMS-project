package azienda.data;

import java.sql.*;

public class CategoriaProdotto {

    public final String NomeProdotto;
    public float PercentualeSconto;

    public CategoriaProdotto(String nomeProdotto, float percentualeSconto) {
        NomeProdotto = nomeProdotto;
        PercentualeSconto = percentualeSconto;
    }

    public String getNomeProdotto() {
        return NomeProdotto;
    }

    public float getPercentualeSconto() {
        return PercentualeSconto;
    }

    public void setPercentualeSconto(float percentualeSconto) {
        PercentualeSconto = percentualeSconto;
    }
    
    public static void addCategoriaProdotto(CategoriaProdotto categoriaProdotto,Connection connection) {
        String sql = "INSERT INTO CategoriaProdotto (NomeProdotto, PercentualeSconto) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, categoriaProdotto.getNomeProdotto());
            statement.setFloat(2, categoriaProdotto.getPercentualeSconto());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
