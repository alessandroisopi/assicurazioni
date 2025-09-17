CREATE TABLE COSTO_POLIZZA (
    ID_CLASSE NUMBER NOT NULL,  --identificativo della classe associata
    COSTO FLOAT NOT NULL,   --costo della polizza
    DT_INIZIO DATE NOT NULL,    --data inizio costo polizza
    DT_FINE DATE,   --data fine costo polizza
    UTENTE_C VARCHAR(16) NOT NULL,   --codice fiscale utente
    PRIMARY KEY(ID_CLASSE, DT_INIZIO)
);

COMMENT ON COLUMN COSTO_POLIZZA.ID_CLASSE IS 'identificativo della classe associata';
COMMENT ON COLUMN COSTO_POLIZZA.COSTO IS 'costo della polizza';
COMMENT ON COLUMN COSTO_POLIZZA.DT_INIZIO IS 'data inizio costo polizza';
COMMENT ON COLUMN COSTO_POLIZZA.DT_FINE IS 'data fine costo polizza';
COMMENT ON COLUMN COSTO_POLIZZA.UTENTE_C IS 'codice fiscale di utente';

ALTER TABLE COSTO_POLIZZA ADD CONSTRAINT FK_CLASSE_COSTO FOREIGN KEY(ID_CLASSE) REFERENCES CLASSE(ID_CLASSE)