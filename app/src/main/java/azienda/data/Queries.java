package azienda.data;

public final class Queries {

    public static final String LIST_PRODUCTS =
        """
        SELECT *
        FROM azienda.prodotto;
        """;

    public static final String FIND_DIPENDENTE =
        """
        SELECT *
        FROM azienda.dipendente
        WHERE CodiceDipendente = ?          
        """;
}
