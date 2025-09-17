CREATE TABLE CLASSE (
    ID_CLASSE NUMBER NOT NULL PRIMARY KEY, --identificativo della classe
    CD_CLASSE VARCHAR2(10) NOT NULL,    --codice classe
    DS_CLASSE VARCHAR2(255) NOT NULL,   --descrizione classe
    DT_INIZIO DATE NOT NULL,    --data inizio della classe
    DT_FINE DATE,    --data fine della classe
    UTENTE_C VARCHAR2(16) NOT NULL  --codice fiscale di utente
);

COMMENT ON COLUMN CLASSE.ID_CLASSE IS 'Identificativo della classe';
COMMENT ON COLUMN CLASSE.CD_CLASSE IS 'Codice classe';
COMMENT ON COLUMN CLASSE.DS_CLASSE IS 'Descrizione classe';
COMMENT ON COLUMN CLASSE.DT_INIZIO IS 'Data inizio della classe';
COMMENT ON COLUMN CLASSE.DT_FINE IS 'Data fine della classe';
COMMENT ON COLUMN CLASSE.UTENTE_C IS 'codice fiscale di utente';