package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.StatoPolizzaDTO;
import it.onyx.assicurazioni.entity.StatoPolizza;
import it.onyx.assicurazioni.repository.StatoPolizzaRepository;
import it.onyx.assicurazioni.util.StatoPolizzaMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatoPolizzaServiceImpl implements StatoPolizzaService {
    @Autowired
    private StatoPolizzaRepository statoPolizzaRepository;

    @Override
    public StatoPolizzaDTO insert(StatoPolizzaDTO dto) {
        try {
            if (dto.getDtFine().isBefore(dto.getDtInizio())) {
                return null;
            }
            StatoPolizza statoPolizza = StatoPolizzaMapper.toEntity(dto);
            StatoPolizzaDTO result = StatoPolizzaMapper.toDto(statoPolizzaRepository.save(statoPolizza));
            if (statoPolizzaRepository.existsById(dto.getIdStatoPolizza())) {
                return result;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<StatoPolizzaDTO> getAll() {
        try {
            List<StatoPolizzaDTO> result = new ArrayList<>();
            for (StatoPolizza s : statoPolizzaRepository.findAll()) {
                result.add(StatoPolizzaMapper.toDto(s));
            }
            return result;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public StatoPolizzaDTO getById(long id) {
        if (statoPolizzaRepository.findById(id).isPresent()) {
            return StatoPolizzaMapper.toDto(statoPolizzaRepository.findById(id).get());
        } else {
            return null;
        }
    }

    @Override
    public StatoPolizzaDTO update(StatoPolizzaDTO dto) {
        try {
            if (statoPolizzaRepository.findById(dto.getIdStatoPolizza()).isPresent()) {
                StatoPolizza statoPolizzaDB = statoPolizzaRepository.findById(dto.getIdStatoPolizza()).get();
                if (dto.getDsStatoPolizza() == null) {
                    dto.setDsStatoPolizza(statoPolizzaDB.getDsStatoPolizza());
                }
                if (dto.getDtInizio() == null) {
                    dto.setDtInizio(statoPolizzaDB.getDtInizio());
                }
                if (dto.getDtFine() == null) {
                    dto.setDtFine(statoPolizzaDB.getDtFine());
                }
                if (dto.getDtFine().isBefore(dto.getDtInizio())) {
                    return null;
                }
                return StatoPolizzaMapper.toDto(statoPolizzaRepository.save(StatoPolizzaMapper.toEntity(dto)));
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean delete(long id) {
        if (statoPolizzaRepository.existsById(id)) {
            statoPolizzaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
