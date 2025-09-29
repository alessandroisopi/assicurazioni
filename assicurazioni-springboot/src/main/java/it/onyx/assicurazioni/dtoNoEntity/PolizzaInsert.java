package it.onyx.assicurazioni.dtoNoEntity;

import it.onyx.assicurazioni.dto.TipoPolizzaDTO;
import it.onyx.assicurazioni.entity.Polizza;
import it.onyx.assicurazioni.repository.PolizzaRepository;

public class PolizzaInsert {

    private Contraente contraente;

    private TipoPolizzaDTO tipoPolizza;

    private String cdIntestatario;

    public PolizzaInsert(Contraente contraente, TipoPolizzaDTO tipoPolizza, String cdIntestatario) {
        this.contraente = contraente;
        this.tipoPolizza = tipoPolizza;
        this.cdIntestatario = cdIntestatario;
    }

    public PolizzaInsert() {
    }

    public Contraente getContraente() {
        return contraente;
    }

    public void setContraente(Contraente contraente) {
        this.contraente = contraente;
    }

    public TipoPolizzaDTO getTipoPolizza() {
        return tipoPolizza;
    }

    public void setTipoPolizza(TipoPolizzaDTO tipoPolizza) {
        this.tipoPolizza = tipoPolizza;
    }

    public String getCdIntestatario() {
        return cdIntestatario;
    }

    public void setCdIntestatario(String cdIntestatario) {
        this.cdIntestatario = cdIntestatario;
    }
}
