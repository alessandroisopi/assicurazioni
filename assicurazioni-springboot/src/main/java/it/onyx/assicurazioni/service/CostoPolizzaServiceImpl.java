package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.context.UserContext;
import it.onyx.assicurazioni.dto.CostoPolizzaDTO;
import it.onyx.assicurazioni.entity.CostoPolizza;
import it.onyx.assicurazioni.entity.CostoPolizzaEmbeddedId;
import it.onyx.assicurazioni.repository.CostoPolizzaRepository;
import it.onyx.assicurazioni.repository.TipoPolizzaRepository;
import it.onyx.assicurazioni.util.CostoPolizzaMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CostoPolizzaServiceImpl implements CostoPolizzaService {

    @Autowired
    private CostoPolizzaRepository costoPolizzaRepository;

    @Autowired
    private TipoPolizzaRepository tipoPolizzaRepository;

    @Override
    public CostoPolizzaDTO insert(CostoPolizzaDTO dto) {
        try {
            if (costoPolizzaRepository.existsById(new CostoPolizzaEmbeddedId(dto.getIdTipoPolizza().getIdTipoPolizza(), dto.getDtInizio()))) {
                return null;
            }
            if (dto.getDtFine() != null) {
                if (dto.getDtFine().isBefore(dto.getDtInizio())){
                    return null;
                }
            }
            CostoPolizza costoPolizza = CostoPolizzaMapper.toEntity(dto);
            if (tipoPolizzaRepository.findById(dto.getIdTipoPolizza().getIdTipoPolizza()).isEmpty()) {
                return null;
            }
            costoPolizza.setIdTipoPolizza(tipoPolizzaRepository.findById(dto.getIdTipoPolizza().getIdTipoPolizza()).get());
            costoPolizza.setUtenteC(UserContext.getUtente().getCodiceFiscale());
            costoPolizza = costoPolizzaRepository.save(costoPolizza);
            if (costoPolizzaRepository.existsById(costoPolizza.getId())) {
                return CostoPolizzaMapper.toDto(costoPolizza);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CostoPolizzaDTO> getAll() {
        try {
            List<CostoPolizzaDTO> result = new ArrayList<>();
            for (CostoPolizza c :  costoPolizzaRepository.findAll()) {
                result.add(CostoPolizzaMapper.toDto(c));
            }
            return result;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public CostoPolizzaDTO getById(long id) {
        try {
            CostoPolizza costoPolizza = costoPolizzaRepository.getById(id);
            if (costoPolizza == null) {
                return null;
            }
            return CostoPolizzaMapper.toDto(costoPolizza);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public CostoPolizzaDTO update(CostoPolizzaDTO dto) {
        try {
            CostoPolizzaEmbeddedId id = new CostoPolizzaEmbeddedId(dto.getIdTipoPolizza().getIdTipoPolizza(), dto.getDtInizio());
            if (costoPolizzaRepository.findById(id).isEmpty()) {
                return null;
            }
            CostoPolizza costoPolizzaDB = costoPolizzaRepository.findById(id).get();
            if (dto.getCosto() == 0) {
               dto.setCosto(costoPolizzaDB.getCosto());
            }
            if (dto.getDtFine() == null) {
                dto.setDtFine(costoPolizzaDB.getDtFine());
            } else {
                if (dto.getDtFine().isBefore(dto.getDtInizio())) {
                    return null;
                }
            }
            dto.setUtenteC(UserContext.getUtente().getCodiceFiscale());
            return CostoPolizzaMapper.toDto(costoPolizzaRepository.save(CostoPolizzaMapper.toEntity(dto)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
