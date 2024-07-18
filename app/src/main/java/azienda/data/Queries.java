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

    public static final String FIND_UTENTE_ONLINE =
        """
        SELECT *
        FROM azienda.utenteonline
        WHERE E_mail = ?          
        """;

    public static final String GET_MONTHLY_SALES =
        """ 
        SELECT MONTH(o.DataOrdine) AS Mese, SUM(do.Quantita) AS NumeroVendite
         FROM
            azienda.ordine o
         JOIN
            DettaglioOrdine do ON o.CodiceOrdine = do.CodiceOrdine
         WHERE
            YEAR(o.DataOrdine) = YEAR(CURDATE()) AND
            do.CodMagazzino = ?
         GROUP BY
            MONTH(o.DataOrdine)
         ORDER BY
            Mese;
        """;
}
