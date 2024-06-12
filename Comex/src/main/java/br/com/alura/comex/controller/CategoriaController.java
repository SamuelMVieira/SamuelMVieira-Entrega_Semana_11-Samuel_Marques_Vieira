package br.com.alura.comex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alura.comex.modelos.Categoria;
import br.com.alura.comex.service.CategoriaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaRequest.getNome());
        Categoria savedCategoria = categoriaService.save(categoria);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

    public static class CategoriaRequest {

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, message = "Nome deve ter pelo menos 2 caracteres")
        private String nome;

        // Getters e Setters

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
