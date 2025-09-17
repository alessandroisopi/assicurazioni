CREATE TABLE STATO_POLIZZA (
    ID_STATO_POLIZZA NUMBER NOT NULL PRIMARY KEY, --identificativo stato polizza
    DS_STATO_POLIZZA VARCHAR2(255) NOT NULL, --descrizione stato polizza
    DT_INIZIO DATE NOT NULL, --data inizio validità dello stato polizza
    DT_FINE DATE,    --data fine validità dello stato polizza
    UTENTE_C VARCHAR2(16) NOT NULL  --codice fiscale di utente
);

COMMENT ON COLUMN STATO_POLIZZA.ID_STATO_POLIZZA IS 'identificativo stato polizza';
COMMENT ON COLUMN STATO_POLIZZA.DS_STATO_POLIZZA IS 'descrizione dello stato della polizza';
COMMENT ON COLUMN STATO_POLIZZA.DT_INIZIO IS 'data inizio validità dello stato polizza';
COMMENT ON COLUMN STATO_POLIZZA.DT_FINE IS 'data fine validità dello stato polizza';
COMMENT ON COLUMN STATO_POLIZZA.UTENTE_C IS 'codice fiscale di utente';