package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.context.UserContext;
import it.onyx.assicurazioni.dto.TipoPolizzaDTO;
import it.onyx.assicurazioni.entity.TipoPolizza;
import it.onyx.assicurazioni.repository.TipoPolizzaRepository;
import it.onyx.assicurazioni.util.TipoPolizzaMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class TipoPolizzaServiceImpl implements TipoPolizzaService {

    @Autowired
    private TipoPolizzaRepository tipoPolizzaRepository;

    @Override
    public List<TipoPolizzaDTO> getAll() {
        try {
            List<TipoPolizzaDTO> result = new ArrayList<>();
            for (TipoPolizza tipoPolizza : tipoPolizzaRepository.findAll()) {
                result.add(TipoPolizzaMapper.toDto(tipoPolizza));
            }
            return result;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public TipoPolizzaDTO getById(long id) {
        try {
            if (tipoPolizzaRepository.findById(id).isPresent()){
                return TipoPolizzaMapper.toDto(tipoPolizzaRepository.findById(id).get());
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public TipoPolizzaDTO update(TipoPolizzaDTO dto) {
        try {
            if (tipoPolizzaRepository.findById(dto.getIdTipoPolizza()).isPresent()) {
                TipoPolizza tipoPolizzaDB = tipoPolizzaRepository.findById(dto.getIdTipoPolizza()).get();
                if (dto.getDsTipoPolizza() == null) {
                    dto.setDsTipoPolizza(tipoPolizzaDB.getDsTipoPolizza());
                }
                if (dto.getDtInizio() == null) {
                    dto.setDtInizio(tipoPolizzaDB.getDtInizio());
                }
                if (dto.getDtFine() == null) {
                    dto.setDtFine(tipoPolizzaDB.getDtFine());
                }
                if (dto.getDtFine().isBefore(tipoPolizzaDB.getDtInizio())) {
                    return null;
                }
                dto.setUtenteC(UserContext.getUtente().getCodiceFiscale());
                return TipoPolizzaMapper.toDto(tipoPolizzaRepository.save(TipoPolizzaMapper.toEntity(dto)));
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
