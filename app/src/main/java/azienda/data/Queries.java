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

      public static final String SHOW_DATI_MAGAZZINIERE = """
                    SELECT
                    d.CodiceDipendente,
                    p.Cognome,
                    p.Nome,
                    p.Telefono,
                    d.Password,
                    df.IBAN,
                    df.Via,
                    df.CAP,
                    df.NumCivico
                    FROM
                    Magazziniere mag
                    JOIN
                    Dipendente d ON mag.CodiceFiscale = d.CodiceFiscale
                    JOIN
                    Persona p ON d.CodiceFiscale = p.CodiceFiscale
                    JOIN
                    Stipendio s ON p.CodiceFiscale = s.CodiceFiscale
                    JOIN
                    DatiFatturazione df ON s.IBAN = df.IBAN
                    ORDER BY
                    p.Cognome, p.Nome;
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

      public static final String DEL_PRODOTTTO = """
                  DELETE FROM azienda.prodotto
                  WHERE NumeroSeriale = ?;
                  """;
}
