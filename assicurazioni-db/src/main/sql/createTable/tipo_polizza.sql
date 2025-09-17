CREATE TABLE TIPO_POLIZZA (
    ID_TIPO_POLIZZA NUMBER NOT NULL PRIMARY KEY, --identificativo del tipo della polizza
    DS_TIPO_POLIZZA VARCHAR2(255) NOT NULL, --descrizione del tipo della polizza
    DT_INIZIO DATE NOT NULL,    --data di inizio della polizza
    DT_FINE DATE,    --data fine della polizza
    UTENTE_C VARCHAR2(16) NOT NULL  --codice fiscale di utente
);

COMMENT ON COLUMN TIPO_POLIZZA.ID_TIPO_POLIZZA IS 'identificativo del tipo della polizza';
COMMENT ON COLUMN TIPO_POLIZZA.DS_TIPO_POLIZZA IS 'descrizione del tipo della polizza';
COMMENT ON COLUMN TIPO_POLIZZA.DT_INIZIO IS 'data di inizio della polizza';
COMMENT ON COLUMN TIPO_POLIZZA.DT_FINE IS 'data fine della polizza';
COMMENT ON COLUMN TIPO_POLIZZA.UTENTE_C IS 'codice fiscale di utente';