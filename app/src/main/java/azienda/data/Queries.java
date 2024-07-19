package azienda.data;

public final class Queries {

    public static final String LIST_PRODUCTS = """
            SELECT *
            FROM azienda.prodotto;
            """;

    public static final String FIND_DIPENDENTE = """
            SELECT *
            FROM azienda.dipendente
            WHERE CodiceDipendente = ?
            """;

    public static final String FIND_UTENTE_ONLINE = """
            SELECT *
            FROM azienda.utenteonline
            WHERE E_mail = ?
            """;

    public static final String GET_MONTHLY_SALES = """
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

    public static final String FIND_PRODUCT = """
            SELECT *
            FROM azienda.prodotto
            WHERE NumeroSeriale = ?
            """;
    public static final String FIND_LOTTO = """
            SELECT *
            FROM azienda.lotto
            WHERE CodiceLotto = ?
            """;
    public static final String FIND_VERSIONE_PRODOTTO = """
            SELECT *
            FROM azienda.versioneprodotto
            WHERE CodiceProdotto = ?
            """;
    public static final String FIND_RIPIANO = """
            SELECT *
            FROM azienda.ripiano
            WHERE CodRipiano = ?
            """;

    public static final String ADD_PRODUCT = """
            INSERT INTO azienda.prodotto(NumeroSeriale,CodiceLotto,,CodPacco,CodiceProdotto,CodRipiano) VALUES
            (?,?,null,?,?);
            """;

    public static final String SHOW_WAREHOUSE_STATISTICS =  """
        SELECT m.CodiceFiscale,p.Nome,p.Cognome,d.CodiceDipendente,
        COUNT(pp.CodPacco) AS NumeroPacchiPreparati
        FROM Magazziniere m
        JOIN Persona p ON m.CodiceFiscale = p.CodiceFiscale
        JOIN Dipendente d ON m.CodiceFiscale = d.CodiceFiscale
        JOIN PaccoPreparato pp ON m.CodiceFiscale = pp.CodiceFiscale
        GROUP BY m.CodiceFiscale, p.Nome, p.Cognome, d.CodiceDipendente
        ORDER BY NumeroPacchiPreparati DESC;
        """;
}
