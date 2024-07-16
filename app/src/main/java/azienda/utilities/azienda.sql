-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.2              
-- * Generator date: Sep 14 2021              
-- * Generation date: Tue Jul 16 17:27:46 2024 
-- * LUN file: C:\Users\Oradzie\Code\DBMS-project\schema-logico.lun 
-- * Schema: AZIENDA/1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database AZIENDA;
use AZIENDA;


-- Tables Section
-- _____________ 

create table Amministratore (
     CodiceFiscale char(20) not null,
     constraint FKDip_Amm_ID primary key (CodiceFiscale));

create table CategoriaProdotto (
     NomeProdotto char(30) not null,
     Pro_Percentuale float(5),
     constraint ID_CategoriaProdotto_ID primary key (NomeProdotto));

create table Colore (
     CodiceProdotto char(20) not null,
     Colore char(20) not null,
     constraint ID_Colore_ID primary key (CodiceProdotto, Colore));

create table Credito (
     CodiceSconto char(10) not null,
     CodiceFiscale char(20) not null,
     constraint ID_Credito_ID primary key (CodiceFiscale, CodiceSconto));

create table DatiFatturazione (
     IBAN char(1) not null,
     Via char(20) not null,
     CAP int not null,
     NumCivico int not null,
     constraint ID_DatiFatturazione_ID primary key (IBAN),
     constraint FKFatturazione_ID unique (Via, CAP, NumCivico));

create table DettaglioOrdine (
     CodiceOrdine char(20) not null,
     Quantita int not null,
     NumeroLinea int not null,
     CodPacco char(20),
     CodiceProdotto char(20) not null,
     CodMagazzino char(20),
     constraint ID_DettaglioOrdine_ID primary key (CodiceOrdine, NumeroLinea),
     constraint FKGes_Det_ID unique (CodPacco));

create table Dipendente (
     CodiceFiscale char(20) not null,
     CodiceDipendente char(20) not null,
     CodMagazzino char(20) not null,
     Password char(50) not null,
     Magazziniere char default null,
     Amministratore char default null,
     constraint SID_Dipendente_ID unique (CodMagazzino, CodiceDipendente),
     constraint FKPer_Dip_ID primary key (CodiceFiscale));

create table Fornitore (
     CodiceFornitore char(20) not null,
     constraint ID_Fornitore_ID primary key (CodiceFornitore));

create table GestioneOrdine (
     CodPacco char(20) not null,
     CodiceFiscale char(20) not null,
     constraint FKGes_Pac_ID primary key (CodPacco));

create table GestioneRifornimento (
     CodiceFiscale char(20) not null,
     CodiceRifornimento char(20) not null,
     constraint ID_GestioneRifornimento_ID primary key (CodiceFiscale, CodiceRifornimento));

create table Indirizzo (
     Via char(20) not null,
     Citta char(20) not null,
     CAP int not null,
     NumCivico int not null,
     constraint ID_Indirizzo_ID primary key (Via, CAP, NumCivico));

create table Inventario (
     Ese_CodiceFiscale char(20) not null,
     Data date not null,
     CodiceFiscale char(20) not null,
     constraint ID_Inventario_ID primary key (Ese_CodiceFiscale, Data));

create table LocazioneUtente (
     Via char(20) not null,
     CAP int not null,
     NumCivico int not null,
     CodiceFiscale char(20) not null,
     constraint ID_LocazioneUtente_ID primary key (Via, CAP, NumCivico, CodiceFiscale));

create table Lotto (
     CodiceLotto char(20) not null,
     Datascadenza date not null,
     constraint ID_Lotto_ID primary key (CodiceLotto));

create table Magazziniere (
     CodiceFiscale char(20) not null,
     constraint FKDip_Mag_ID primary key (CodiceFiscale));

create table Magazzino (
     DataFondazione date not null,
     CodMagazzino char(20) not null,
     Via char(20) not null,
     CAP int not null,
     NumCivico int not null,
     constraint ID_Magazzino_ID primary key (CodMagazzino),
     constraint FKLocazioneMagazzino_ID unique (Via, CAP, NumCivico));

create table Ordine (
     CodiceOrdine char(20) not null,
     DataOrdine date not null,
     IndirizzoDestinatario char(30) not null,
     CodiceSconto char(10),
     CodicePromo char(20),
     CodiceFiscale char(20) not null,
     constraint ID_Ordine_ID primary key (CodiceOrdine));

create table PaccoPreparato (
     CodPacco char(20) not null,
     CodiceFiscale char(20) not null,
     constraint ID_PaccoPreparato_ID primary key (CodPacco),
     constraint SID_PaccoPreparato_ID unique (CodiceFiscale, CodPacco));

create table Persona (
     Nome char(30) not null,
     Cognome char(30) not null,
     CodiceFiscale char(20) not null,
     Telefono bigint not null,
     UtenteOnline char,
     Dipendente char,
     constraint ID_Persona_ID primary key (CodiceFiscale));

create table Prodotto (
     NumeroSeriale char(20) not null,
     CodiceLotto char(20) not null,
     CodPacco char(20),
     CodiceProdotto char(20) not null,
     CodRipiano char(20) not null,
     constraint ID_Prodotto_ID primary key (NumeroSeriale));

create table QuantitaLotti (
     CodiceLotto char(20) not null,
     CodiceRifornimento char(20) not null,
     numero int not null,
     constraint ID_QuantitaLotti_ID primary key (CodiceLotto, CodiceRifornimento));

create table Rifornimento (
     CodiceRifornimento char(20) not null,
     CodiceFornitore char(20) not null,
     CodiceFiscale char(20) not null,
     constraint ID_Rifornimento_ID primary key (CodiceRifornimento));

create table Ripiano (
     CodRipiano char(20) not null,
     CodScaffale char(20) not null,
     constraint ID_Ripiano_ID primary key (CodRipiano));

create table Scaffale (
     CodScaffale char(20) not null,
     CodSettore char(20) not null,
     constraint ID_Scaffale_ID primary key (CodScaffale));

create table ScontoUtente (
     PercentualeScontoUtente float(5) not null,
     CodiceSconto char(10) not null,
     constraint ID_ScontoUtente_ID primary key (CodiceSconto));

create table Settore (
     CodSettore char(20) not null,
     CodMagazzino char(20) not null,
     constraint ID_Settore_ID primary key (CodSettore));

create table Stipendio (
     CodiceFiscale char(20) not null,
     Importo float(10) not null,
     Bonus float(10),
     DataEmissione date not null,
     IBAN char(1) not null,
     constraint ID_Stipendio_ID primary key (CodiceFiscale, DataEmissione));

create table UtenteOnline (
     CodiceFiscale char(20) not null,
     Password char(20) not null,
     E_mail char(30) not null,
     constraint SID_UtenteOnline_ID unique (E_mail),
     constraint FKPer_Ute_ID primary key (CodiceFiscale));

create table VenditaPromozionale (
     DataFine date not null,
     DataInizio date not null,
     PercentualeSconto float(5) not null,
     CodicePromo char(20) not null,
     constraint ID_VenditaPromozionale_ID primary key (CodicePromo));

create table VersioneProdotto (
     Specifiche char(100) not null,
     Disponibilita int not null,
     CodiceProdotto char(20) not null,
     NomeProdotto char(30) not null,
     constraint ID_VersioneProdotto_ID primary key (CodiceProdotto));


-- Constraints Section
-- ___________________ 

alter table Amministratore add constraint FKDip_Amm_FK
     foreign key (CodiceFiscale)
     references Dipendente (CodiceFiscale);

alter table Colore add constraint FKVer_Col
     foreign key (CodiceProdotto)
     references VersioneProdotto (CodiceProdotto);

alter table Credito add constraint FKCre_Ute
     foreign key (CodiceFiscale)
     references UtenteOnline (CodiceFiscale);

alter table Credito add constraint FKCre_Sco_FK
     foreign key (CodiceSconto)
     references ScontoUtente (CodiceSconto);

alter table DatiFatturazione add constraint FKFatturazione_FK
     foreign key (Via, CAP, NumCivico)
     references Indirizzo (Via, CAP, NumCivico);

alter table DettaglioOrdine add constraint FKRiferimento_FK
     foreign key (CodiceProdotto)
     references VersioneProdotto (CodiceProdotto);

alter table DettaglioOrdine add constraint FKGes_Det_FK
     foreign key (CodPacco)
     references GestioneOrdine (CodPacco);

alter table DettaglioOrdine add constraint FKComposizione
     foreign key (CodiceOrdine)
     references Ordine (CodiceOrdine);

alter table DettaglioOrdine add constraint FKCommissionato_FK
     foreign key (CodMagazzino)
     references Magazzino (CodMagazzino);

alter table Dipendente add constraint EXTONE_Dipendente
     check((Magazziniere is not null and Amministratore is null)
           or (Magazziniere is null and Amministratore is not null)); 

alter table Dipendente add constraint FKReferenza
     foreign key (CodMagazzino)
     references Magazzino (CodMagazzino);

alter table Dipendente add constraint FKPer_Dip_FK
     foreign key (CodiceFiscale)
     references Persona (CodiceFiscale);

-- Not implemented
-- alter table GestioneOrdine add constraint FKGes_Pac_CHK
--     check(exists(select * from DettaglioOrdine
--                  where DettaglioOrdine.CodPacco = CodPacco)); 

alter table GestioneOrdine add constraint FKGes_Pac_FK
     foreign key (CodPacco)
     references PaccoPreparato (CodPacco);

alter table GestioneOrdine add constraint FKGes_Amm_FK
     foreign key (CodiceFiscale)
     references Amministratore (CodiceFiscale);

alter table GestioneRifornimento add constraint FKGes_Rif_FK
     foreign key (CodiceRifornimento)
     references Rifornimento (CodiceRifornimento);

alter table GestioneRifornimento add constraint FKGes_Mag
     foreign key (CodiceFiscale)
     references Magazziniere (CodiceFiscale);

alter table Inventario add constraint FKCommissione_FK
     foreign key (CodiceFiscale)
     references Amministratore (CodiceFiscale);

alter table Inventario add constraint FKEsecuzione
     foreign key (Ese_CodiceFiscale)
     references Magazziniere (CodiceFiscale);

alter table LocazioneUtente add constraint FKLoc_Ute_FK
     foreign key (CodiceFiscale)
     references UtenteOnline (CodiceFiscale);

alter table LocazioneUtente add constraint FKLoc_Ind
     foreign key (Via, CAP, NumCivico)
     references Indirizzo (Via, CAP, NumCivico);

-- Not implemented
-- alter table Lotto add constraint ID_Lotto_CHK
--     check(exists(select * from Prodotto
--                  where Prodotto.CodiceLotto = CodiceLotto)); 

-- Not implemented
-- alter table Lotto add constraint ID_Lotto_CHK
--     check(exists(select * from QuantitaLotti
--                  where QuantitaLotti.CodiceLotto = CodiceLotto)); 

alter table Magazziniere add constraint FKDip_Mag_FK
     foreign key (CodiceFiscale)
     references Dipendente (CodiceFiscale);

-- Not implemented
-- alter table Magazzino add constraint ID_Magazzino_CHK
--     check(exists(select * from Dipendente
--                  where Dipendente.CodMagazzino = CodMagazzino)); 

alter table Magazzino add constraint FKLocazioneMagazzino_FK
     foreign key (Via, CAP, NumCivico)
     references Indirizzo (Via, CAP, NumCivico);

-- Not implemented
-- alter table Ordine add constraint ID_Ordine_CHK
--     check(exists(select * from DettaglioOrdine
--                  where DettaglioOrdine.CodiceOrdine = CodiceOrdine)); 

alter table Ordine add constraint FKRiscossione_FK
     foreign key (CodiceSconto)
     references ScontoUtente (CodiceSconto);

alter table Ordine add constraint FKPossedere_FK
     foreign key (CodicePromo)
     references VenditaPromozionale (CodicePromo);

alter table Ordine add constraint FKEffettuazione_FK
     foreign key (CodiceFiscale)
     references UtenteOnline (CodiceFiscale);

-- Not implemented
-- alter table PaccoPreparato add constraint ID_PaccoPreparato_CHK
--     check(exists(select * from GestioneOrdine
--                  where GestioneOrdine.CodPacco = CodPacco)); 

-- Not implemented
-- alter table PaccoPreparato add constraint ID_PaccoPreparato_CHK
--     check(exists(select * from Prodotto
--                  where Prodotto.CodPacco = CodPacco)); 

alter table PaccoPreparato add constraint FKPreparazioneOrdine
     foreign key (CodiceFiscale)
     references Magazziniere (CodiceFiscale);

alter table Persona add constraint LSTONE_Persona
     check(UtenteOnline is not null or Dipendente is not null); 

alter table Prodotto add constraint FKPresenza_FK
     foreign key (CodiceLotto)
     references Lotto (CodiceLotto);

alter table Prodotto add constraint FKInserimento_FK
     foreign key (CodPacco)
     references PaccoPreparato (CodPacco);

alter table Prodotto add constraint FKDisponibilita_FK
     foreign key (CodiceProdotto)
     references VersioneProdotto (CodiceProdotto);

alter table Prodotto add constraint FKContenimento_FK
     foreign key (CodRipiano)
     references Ripiano (CodRipiano);

alter table QuantitaLotti add constraint FKRichiestaQuantita_FK
     foreign key (CodiceRifornimento)
     references Rifornimento (CodiceRifornimento);

alter table QuantitaLotti add constraint FKRichiestaLotto
     foreign key (CodiceLotto)
     references Lotto (CodiceLotto);

-- Not implemented
-- alter table Rifornimento add constraint ID_Rifornimento_CHK
--     check(exists(select * from QuantitaLotti
--                  where QuantitaLotti.CodiceRifornimento = CodiceRifornimento)); 

alter table Rifornimento add constraint FKFornitura_FK
     foreign key (CodiceFornitore)
     references Fornitore (CodiceFornitore);

alter table Rifornimento add constraint FKRichiesta_FK
     foreign key (CodiceFiscale)
     references Amministratore (CodiceFiscale);

alter table Ripiano add constraint FKAppartenenzaScaffale_FK
     foreign key (CodScaffale)
     references Scaffale (CodScaffale);

alter table Scaffale add constraint FKAppartenenzaSettore_FK
     foreign key (CodSettore)
     references Settore (CodSettore);

alter table Settore add constraint FKDivisione_FK
     foreign key (CodMagazzino)
     references Magazzino (CodMagazzino);

alter table Stipendio add constraint FKDestinazione_FK
     foreign key (IBAN)
     references DatiFatturazione (IBAN);

alter table Stipendio add constraint FKRisquote
     foreign key (CodiceFiscale)
     references Dipendente (CodiceFiscale);

alter table UtenteOnline add constraint FKPer_Ute_FK
     foreign key (CodiceFiscale)
     references Persona (CodiceFiscale);

alter table VersioneProdotto add constraint FKAppartenenza_FK
     foreign key (NomeProdotto)
     references CategoriaProdotto (NomeProdotto);


-- Index Section
-- _____________ 

create unique index FKDip_Amm_IND
     on Amministratore (CodiceFiscale);

create unique index ID_CategoriaProdotto_IND
     on CategoriaProdotto (NomeProdotto);

create unique index ID_Colore_IND
     on Colore (CodiceProdotto, Colore);

create unique index ID_Credito_IND
     on Credito (CodiceFiscale, CodiceSconto);

create index FKCre_Sco_IND
     on Credito (CodiceSconto);

create unique index ID_DatiFatturazione_IND
     on DatiFatturazione (IBAN);

create unique index FKFatturazione_IND
     on DatiFatturazione (Via, CAP, NumCivico);

create unique index ID_DettaglioOrdine_IND
     on DettaglioOrdine (CodiceOrdine, NumeroLinea);

create index FKRiferimento_IND
     on DettaglioOrdine (CodiceProdotto);

create unique index FKGes_Det_IND
     on DettaglioOrdine (CodPacco);

create index FKCommissionato_IND
     on DettaglioOrdine (CodMagazzino);

create unique index SID_Dipendente_IND
     on Dipendente (CodMagazzino, CodiceDipendente);

create unique index FKPer_Dip_IND
     on Dipendente (CodiceFiscale);

create unique index ID_Fornitore_IND
     on Fornitore (CodiceFornitore);

create unique index FKGes_Pac_IND
     on GestioneOrdine (CodPacco);

create index FKGes_Amm_IND
     on GestioneOrdine (CodiceFiscale);

create unique index ID_GestioneRifornimento_IND
     on GestioneRifornimento (CodiceFiscale, CodiceRifornimento);

create index FKGes_Rif_IND
     on GestioneRifornimento (CodiceRifornimento);

create unique index ID_Indirizzo_IND
     on Indirizzo (Via, CAP, NumCivico);

create unique index ID_Inventario_IND
     on Inventario (Ese_CodiceFiscale, Data);

create index FKCommissione_IND
     on Inventario (CodiceFiscale);

create unique index ID_LocazioneUtente_IND
     on LocazioneUtente (Via, CAP, NumCivico, CodiceFiscale);

create index FKLoc_Ute_IND
     on LocazioneUtente (CodiceFiscale);

create unique index ID_Lotto_IND
     on Lotto (CodiceLotto);

create unique index FKDip_Mag_IND
     on Magazziniere (CodiceFiscale);

create unique index ID_Magazzino_IND
     on Magazzino (CodMagazzino);

create unique index FKLocazioneMagazzino_IND
     on Magazzino (Via, CAP, NumCivico);

create unique index ID_Ordine_IND
     on Ordine (CodiceOrdine);

create index FKRiscossione_IND
     on Ordine (CodiceSconto);

create index FKPossedere_IND
     on Ordine (CodicePromo);

create index FKEffettuazione_IND
     on Ordine (CodiceFiscale);

create unique index ID_PaccoPreparato_IND
     on PaccoPreparato (CodPacco);

create unique index SID_PaccoPreparato_IND
     on PaccoPreparato (CodiceFiscale, CodPacco);

create unique index ID_Persona_IND
     on Persona (CodiceFiscale);

create unique index ID_Prodotto_IND
     on Prodotto (NumeroSeriale);

create index FKPresenza_IND
     on Prodotto (CodiceLotto);

create index FKInserimento_IND
     on Prodotto (CodPacco);

create index FKDisponibilita_IND
     on Prodotto (CodiceProdotto);

create index FKContenimento_IND
     on Prodotto (CodRipiano);

create unique index ID_QuantitaLotti_IND
     on QuantitaLotti (CodiceLotto, CodiceRifornimento);

create index FKRichiestaQuantita_IND
     on QuantitaLotti (CodiceRifornimento);

create unique index ID_Rifornimento_IND
     on Rifornimento (CodiceRifornimento);

create index FKFornitura_IND
     on Rifornimento (CodiceFornitore);

create index FKRichiesta_IND
     on Rifornimento (CodiceFiscale);

create unique index ID_Ripiano_IND
     on Ripiano (CodRipiano);

create index FKAppartenenzaScaffale_IND
     on Ripiano (CodScaffale);

create unique index ID_Scaffale_IND
     on Scaffale (CodScaffale);

create index FKAppartenenzaSettore_IND
     on Scaffale (CodSettore);

create unique index ID_ScontoUtente_IND
     on ScontoUtente (CodiceSconto);

create unique index ID_Settore_IND
     on Settore (CodSettore);

create index FKDivisione_IND
     on Settore (CodMagazzino);

create unique index ID_Stipendio_IND
     on Stipendio (CodiceFiscale, DataEmissione);

create index FKDestinazione_IND
     on Stipendio (IBAN);

create unique index SID_UtenteOnline_IND
     on UtenteOnline (E_mail);

create unique index FKPer_Ute_IND
     on UtenteOnline (CodiceFiscale);

create unique index ID_VenditaPromozionale_IND
     on VenditaPromozionale (CodicePromo);

create unique index ID_VersioneProdotto_IND
     on VersioneProdotto (CodiceProdotto);

create index FKAppartenenza_IND
     on VersioneProdotto (NomeProdotto);

