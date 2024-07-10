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

create table Amministratore (
);

create table Categoria Prodotto (
	NomeProdotto -- ERROR
	Promozione -- ERROR
,
	primary key (NomeProdotto -- atr decomp --));

create table Dettaglio Ordine (
	Quantit� char(1) not null,
	Numero Linea char(1) not null,
	primary key (, Numero Linea));

create table Dipendente (
	CodiceDipendente char(1) not null,
	IBAN char(1) not null,
	Indirizzo Di Fatturazione char(1) not null,
	unique (, CodiceDipendente));

create table Fornitore (
	CodiceFornitore char(1) not null,
	primary key (CodiceFornitore));

create table Inventario (
	Data char(1) not null,
	primary key (, Data));

create table Lotto (
	CodiceLotto char(1) not null,
	Data scadenza char(1) not null,
	primary key (CodiceLotto));

create table Magazziniere (
);

create table Magazzino (
	Cod. magazzino char(1) not null,
	Indirizzo -- ERROR
,
	primary key (Cod. magazzino));

create table Ordine (
	CodiceOrdine char(1) not null,
	Sconto numeric(1),
	DataOrdine char(1) not null,
	IndirizzoSpedizione char(1) not null,
	primary key (CodiceOrdine));

create table Pacco Preparato (
	CodPacco char(1) not null,
	primary key (CodPacco),
	unique (, CodPacco));

create table Persona (
	Nome char(1) not null,
	Cognome char(1) not null,
	CodiceFiscale char(1) not null,
	Telefono char(1) not null,
	primary key (CodiceFiscale));

create table Prodotto (
	NumeroSeriale char(1) not null,
	primary key (NumeroSeriale),
	unique (, NumeroSeriale));

create table Rifornimento (
	CodiceRifornimento char(1) not null,
	primary key (CodiceRifornimento));

create table Ripiano (
	Cod. Ripiano char(1) not null,
	primary key (Cod. Ripiano));

create table Scaffale (
	Cod. Scaffale char(1) not null,
	primary key (Cod. Scaffale));

create table Sconto Utente (
	Percentuale char(1) not null,
	CodiceSconto char(1) not null,
	primary key (CodiceSconto));

create table Settore (
	Cod. Settore char(1) not null,
	primary key (Cod. Settore));

create table Utente Online (
	Username char(1) not null,
	Indirizzo di Spedizione -- ERROR
,
	unique (Username));

create table Vendita Promozionale (
	DataFine char(1) not null,
	DataInizio -- ERROR
	PercentualeSconto char(1) not null,
	CodicePromo -- ERROR
,
	primary key (CodicePromo -- atr decomp --));

create table Versione Prodotto (
	Colore char(1),
	Specifiche char(1) not null,
	Disponibilit� numeric(1) not null,
	CodiceProdotto char(1) not null,
	primary key (CodiceProdotto));


-- Constraints Section
-- ___________________


-- Index Section
-- _____________
