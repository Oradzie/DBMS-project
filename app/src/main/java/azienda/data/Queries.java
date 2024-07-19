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

   public static final String SHOW_WAREHOUSE_STATISTICS = """
         SELECT m.CodiceFiscale,p.Nome,p.Cognome,d.CodiceDipendente,
         COUNT(pp.CodPacco) AS NumeroPacchiPreparati
         FROM Magazziniere m
         JOIN Persona p ON m.CodiceFiscale = p.CodiceFiscale
         JOIN Dipendente d ON m.CodiceFiscale = d.CodiceFiscale
         JOIN PaccoPreparato pp ON m.CodiceFiscale = pp.CodiceFiscale
         WHERE d.CodMagazzino = ?
         GROUP BY m.CodiceFiscale, p.Nome, p.Cognome, d.CodiceDipendente
         ORDER BY NumeroPacchiPreparati DESC;
         """;

   public static final String GET_PRODUCT_SALES = """
             SELECT
                 cp.NomeProdotto,
                 COUNT(*) AS NumeroVendite
             FROM
                 Ordine o
             JOIN
                 DettaglioOrdine do ON o.CodiceOrdine = do.CodiceOrdine
             JOIN
                 VersioneProdotto vp ON do.CodiceProdotto = vp.CodiceProdotto
             JOIN
                 CategoriaProdotto cp ON vp.NomeProdotto = cp.NomeProdotto
             JOIN
                 Magazzino m ON do.CodMagazzino = m.CodMagazzino
             WHERE
                 m.CodMagazzino = ?
             GROUP BY
                 cp.NomeProdotto;
         """;

   public static final String FIND_VIA = """
         SELECT *
         FROM azienda.indirizzo
         WHERE Via = ?
         """;
   public static final String FIND_CAP = """
         SELECT *
         FROM azienda.indirizzo
         WHERE CAP = ?
         """;
   public static final String FIND_NUMCIVICO = """
         SELECT *
         FROM azienda.indirizzo
         WHERE NumCivico = ?
         """;
   public static final String ADD_ADDRESS = """
         INSERT INTO azienda.indirizzo(Via, Citta, CAP, NumCivico) VALUES
         (?,?,?,?);
         """;
}
