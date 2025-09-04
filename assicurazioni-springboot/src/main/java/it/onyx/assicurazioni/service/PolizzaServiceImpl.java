package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.entity.Polizza;
import it.onyx.assicurazioni.repository.PolizzaRepository;
import it.onyx.assicurazioni.util.Conversioni;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PolizzaServiceImpl implements PolizzaService {
    @Autowired
    private PolizzaRepository polizzaRepository;

    @Override
    public PolizzaDTO insert(PolizzaDTO dto) {
        Polizza polizza = Conversioni.daPolizzaDTOAPolizza(dto);
        polizza = polizzaRepository.save(polizza);
        if (polizzaRepository.existsById(dto.getIdPolizza())) {
            return Conversioni.daPolizzaAPolizzaDTO(polizza);
        } else {
            return null;
        }
    }

    @Override
    public List<PolizzaDTO> getAll() {
        List<PolizzaDTO> result = new ArrayList<>();
        for (Polizza p : polizzaRepository.findAll()) {
            result.add(Conversioni.daPolizzaAPolizzaDTO(p));
        }
        return result;
    }

    @Override
    public PolizzaDTO getById(long id) {
        if (polizzaRepository.existsById(id)) {
            return Conversioni.daPolizzaAPolizzaDTO(polizzaRepository.findById(id).get());
        } else {
            return null;
        }
    }

    @Override
    public PolizzaDTO update(PolizzaDTO dto) {
        if (polizzaRepository.existsById(dto.getIdPolizza())) {
           Polizza polizza = polizzaRepository.save(Conversioni.daPolizzaDTOAPolizza(dto));
           return  Conversioni.daPolizzaAPolizzaDTO(polizza);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        if (polizzaRepository.existsById(id)) {
            polizzaRepository.deleteById(id);
            return true;
        } else  {
            return false;
        }
    }
}
