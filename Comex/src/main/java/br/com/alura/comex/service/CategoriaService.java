package br.com.alura.comex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.alura.comex.modelos.Categoria;
import br.com.alura.comex.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria) {
        // Define a categoria como ativa
        categoria.setStatus(true);
        return categoriaRepository.save(categoria);
    }
}

