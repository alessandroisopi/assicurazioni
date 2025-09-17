package it.onyx.assicurazioni.util;

import it.onyx.assicurazioni.dto.UtenteDTO;
import it.onyx.assicurazioni.entity.Utente;

public class UtenteMapper {

    public static UtenteDTO toDto(Utente utente) {
        return new UtenteDTO(
                utente.getCodiceFiscale(),
                utente.getNome(),
                utente.getCognome(),
                utente.getDataNascita()
        );
    }

    public static Utente toEntity(UtenteDTO dto) {
        return new Utente(
                dto.getCodiceFiscale(),
                dto.getNome(),
                dto.getCognome(),
                dto.getDataNascita()
        );
    }
}
