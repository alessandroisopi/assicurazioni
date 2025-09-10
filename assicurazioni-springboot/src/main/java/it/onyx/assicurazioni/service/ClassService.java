package it.onyx.assicurazioni.service;

import it.onyx.assicurazioni.dto.ClasseDTO;

import java.util.List;

public interface ClassService {
    public List<ClasseDTO>  getAll();
    public ClasseDTO getById(long id);
    public ClasseDTO update(ClasseDTO dto);
}
