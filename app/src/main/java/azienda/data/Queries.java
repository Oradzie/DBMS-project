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
                        INSERT INTO azienda.prodotto(NumeroSeriale,CodiceLotto,CodPacco,CodiceProdotto,CodRipiano) VALUES
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
        public static final String ADD_PERSONA_MAG = """
                        INSERT INTO azienda.persona(Nome,Cognome,CodiceFiscale,Telefono,UtenteOnline,Dipendente) VALUES
                        (?,?,?,?,null,true);
                        """;
        public static final String ADD_DIPENDENTE_MAG = """
                        INSERT INTO azienda.dipendente (CodiceFiscale, CodiceDipendente, CodMagazzino, Password, Magazziniere, Amministratore) VALUES
                        (?,?,?,?,true,null);
                        """;
        public static final String ADD_MAGAZZINIERE = """
                        INSERT INTO azienda.magazziniere (CodiceFiscale) VALUES
                        (?)
                        """;

        public static final String GET_MOST_SOLD_PRODUCT = """
                          SELECT
                              Mese,
                              NomeProdotto,
                              MAX(NumeroVendite) AS NumeroVendite
                          FROM (
                              SELECT
                                  EXTRACT(MONTH FROM o.DataOrdine) AS Mese,
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
                                  AND EXTRACT(YEAR FROM o.DataOrdine) = EXTRACT(YEAR FROM CURRENT_DATE)
                              GROUP BY
                                  EXTRACT(MONTH FROM o.DataOrdine),
                                  cp.NomeProdotto
                          ) AS VenditePerMese
                          GROUP BY
                              Mese,
                              NomeProdotto
                          ORDER BY
                              Mese;
                        """;

        public static final String DEL_PRODOTTO = """
                        DELETE FROM azienda.prodotto
                        WHERE NumeroSeriale = ?;
                        """;
        public static final String VIEW_PRODOTTO = """
                        SELECT *
                        FROM azienda.versioneprodotto
                        WHERE CodiceProdotto = ?;
                        """;

        public static final String LIST_FORNITORI = """
                        SELECT *
                        FROM azienda.fornitore;
                        """;

        public static final String LIST_VERSIONE_PRODOTTO = """
                        SELECT *
                        FROM azienda.versioneprodotto;
                        """;

        public static final String VIEW_STORICO_ORDINI = """
                        SELECT
                        o.CodiceOrdine,
                        o.DataOrdine,
                        o.IndirizzoDestinatario,
                        ou.CodiceSconto,
                        su.PercentualeScontoUtente,
                        vp.PercentualeSconto,
                        do.CodiceProdotto,
                        vp2.Specifiche,
                        do.Quantita,
                        p.NumeroSeriale,
                        p.CodiceLotto,
                        pp.CodPacco,
                        o.CodiceFiscale,
                        CONCAT(up.Nome,'', up.Cognome) AS NomeCompleto
                        FROM Ordine o
                        LEFT JOIN Credito ou ON o.CodiceSconto = ou.CodiceSconto AND o.CodiceFiscale = ou.CodiceFiscale
                        LEFT JOIN ScontoUtente su ON ou.CodiceSconto = su.CodiceSconto
                        LEFT JOIN VenditaPromozionale vp ON o.CodicePromo = vp.CodicePromo
                        JOIN DettaglioOrdine do ON o.CodiceOrdine = do.CodiceOrdine
                        JOIN Prodotto p ON do.CodiceProdotto = p.CodiceProdotto
                        JOIN PaccoPreparato pp ON do.CodPacco = pp.CodPacco
                        JOIN UtenteOnline u ON o.CodiceFiscale = u.CodiceFiscale
                        JOIN Persona up ON u.CodiceFiscale = up.CodiceFiscale
                        JOIN VersioneProdotto vp2 ON do.CodiceProdotto = vp2.CodiceProdotto
                        WHERE o.CodiceFiscale = ?
                        ORDER BY o.DataOrdine DESC, o.CodiceOrdine ASC;

                        """;

        public static final String LIST_PROMOZIONI = """
                        SELECT *
                        FROM azienda.venditapromozionale;
                        """;

        public static final String ADD_RIFORNIMENTO = """
                        CALL AggiungiRifornimentoLottoQuantita(?, ?, ?);
                        """;

        public static final String VIEW_ORDINI = """
                        SELECT CodiceOrdine
                        FROM azienda.ordine;
                        """;
        public static final String ADD_ORDINE = """
                        INSERT INTO azienda.ordine (CodiceOrdine, DataOrdine, IndirizzoDestinatario, CodiceSconto, CodicePromo, CodiceFiscale) VALUES
                        (?,?,?,?,?,?);
                        """;

        public static final String ADD_DETTAGLIO_ORDINE = """
                        INSERT INTO azienda.dettaglioordine (CodiceOrdine, Quantita, NumeroLinea, CodPacco, CodiceProdotto, CodMagazzino) VALUES
                        (?,?,?,null,?,?);
                        """;
}
