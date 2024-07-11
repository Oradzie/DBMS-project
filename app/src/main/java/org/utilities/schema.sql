-- ***************************
-- * Standard SQL generation *
-- ***************************


-- Database Section
-- ________________

create database SCHEMA;


-- TableSpace Section
-- __________________

-- Table Section
-- _____________

create table Amministratore ();

create table CategoriaProdotto (
	NomeProdotto char(30) not null,
	primary key (NomeProdotto));

create table DettaglioOrdine (
	Quantita numeric(4) not null,
	NumeroLinea numeric(3) not null,
	primary key (, NumeroLinea));

create table Dipendente (
	CodiceDipendente char(20) not null,
	IBAN char(30) not null,
	IndirizzoFatturazione char(30) not null,
	unique (, CodiceDipendente));

create table PromozioneCategoria (
	IDPromozione char(20) not null,
	Percentuale float(5) not null,
	primary key (IDPromozione));

create table QuantitaLotti (
	numero numeric(4) not null,
	primary key (, numero));

create table Fornitore (
	CodiceFornitore char(20) not null,
	primary key (CodiceFornitore));

create table Indirizzo (
	Via char(20) not null,
	Citt� char(20) not null,
	CAP numeric(5) not null,
	NumCivico numeric(4) not null,
	primary key (Via, CAP, NumCivico));

create table Inventario (
	Data date not null,
	primary key (, Data));

create table Lotto (
	CodiceLotto char(20) not null,
	Datascadenza date not null,
	primary key (CodiceLotto));

create table Magazziniere (
);

create table Magazzino (
	DataFondazione date not null,
	CodMagazzino char(20) not null,
	primary key (CodMagazzino));

create table Ordine (
	CodiceOrdine char(20) not null,
	DataOrdine date not null,
	IndirizzoDestinatario char(30) not null,
	primary key (CodiceOrdine));

create table PaccoPreparato (
	CodPacco char(20) not null,
	primary key (CodPacco),
	unique (, CodPacco));

create table Persona (
	Nome char(30) not null,
	Cognome char(30) not null,
	CodiceFiscale char(20) not null,
	Telefono numeric(15) not null,
	primary key (CodiceFiscale));

create table Prodotto (
	NumeroSeriale char(20) not null,
	primary key (NumeroSeriale));

create table Rifornimento (
	CodiceRifornimento char(20) not null,
	primary key (CodiceRifornimento));

create table Ripiano (
	CodRipiano char(20) not null,
	primary key (CodRipiano));

create table Scaffale (
	CodScaffale char(20) not null,
	primary key (CodScaffale));

create table ScontoUtente (
	PercentualeScontoUtente float(5) not null,
	CodiceSconto char(10) not null,
	primary key (CodiceSconto));

create table Settore (
	CodSettore char(20) not null,
	primary key (CodSettore));

create table UtenteOnline (
	Username char(30) not null,
	Password char(20) not null,
	E-mail char(30) not null,
	unique (Username));

create table VenditaPromozionale (
	DataFine date not null,
	DataInizio date not null,
	PercentualeSconto float(5) not null,
	CodicePromo char(20) not null,
	primary key (CodicePromo));

create table VersioneProdotto (
	Colore char(20),
	Specifiche char(100) not null,
	Disponibilita numeric(4) not null,
	CodiceProdotto char(20) not null,
	primary key (CodiceProdotto));


-- Constraints Section
-- ___________________


-- Index Section
-- _____________

