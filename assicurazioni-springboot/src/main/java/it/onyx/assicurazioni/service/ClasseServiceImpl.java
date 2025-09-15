package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.ClasseDTO;
import it.onyx.assicurazioni.entity.Classe;
import it.onyx.assicurazioni.repository.ClasseRepository;
import it.onyx.assicurazioni.util.ClasseMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Override
    public List<ClasseDTO> getAll() {
        try {
            List<ClasseDTO> result = new ArrayList<>(); //crea lista per i risultati
            for (Classe c : classeRepository.findAll()) {   //itera tutta la lista di entità
                result.add(ClasseMapper.toDto(c)); //converte ogni lista in dto e inserisce nel risultato
            }
            return result;
        } catch (Exception e){
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public ClasseDTO getById(long id) {
        try {
            if (classeRepository.findById(id).isPresent()) {    //controlla se esiste l'oggetto con l'id passato
                return ClasseMapper.toDto(classeRepository.findById(id).get());    //ritorna l'oggetto se presente
            } else {
                return null;    //ritorna nulla se non presente
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public ClasseDTO update(ClasseDTO dto) {
        if (classeRepository.findById(dto.getIdClasse()).isPresent()) { //verifica l'esistenza dell'oggetto da modificare
            Classe classeDB = classeRepository.findById(dto.getIdClasse()).get();   //ottiene una copia dell'oggetto per controllare ciò che è stato modificato
            if (dto.getCdClasse() == null) {    //serie di if che controlla quali campi sono nulla e li rimpiazza con quelli da database
                dto.setCdClasse(classeDB.getCdClasse());
            }
            if (dto.getDsClasse() == null) {
                dto.setDsClasse(classeDB.getDsClasse());
            }
            if (dto.getDtInizio() == null) {
                dto.setDtInizio(classeDB.getDtInizio());
            }
            if (dto.getDtFine() == null) {
                dto.setDtFine(classeDB.getDtFine());
            }
            if (dto.getDtFine().isBefore(dto.getDtInizio())) {  //controlla se la data è coerente
                return null;
            }
            return ClasseMapper.toDto(classeRepository.save(ClasseMapper.toEntity(dto)));    //effetua il salvataggio e ritorna l'oggetto modificato
        } else {
            return null;
        }
    }
}
