package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.ClasseDTO;

import java.util.List;

public interface ClasseService {
    List<ClasseDTO>  getAll();
    ClasseDTO getById(long id);
    ClasseDTO update(ClasseDTO dto);
}
