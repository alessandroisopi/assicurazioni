CREATE TABLE POLIZZA (
    ID_POLIZZA NUMBER NOT NULL PRIMARY KEY, --identificativo polizza
    ID_TIPO_POLIZZA NUMBER NOT NULL,    --identificativo tipo polizza
    ID_CLASSE NUMBER NOT NULL,  --identificativo classe polizza
    ID_INTESTATARIO NUMBER NOT NULL,    --identificativo intestatario polizza
    ID_STATO_POLIZZA NUMBER NOT NULL,   --identificativo stato polizza
    DT_INIZIO DATE NOT NULL,    --data inizio polizza
    DT_FINE DATE NOT NULL,  --data fine polizza
    NOTE VARCHAR2(255)  --note polizza
);