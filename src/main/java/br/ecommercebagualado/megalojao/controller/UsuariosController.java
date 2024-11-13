package br.ecommercebagualado.megalojao.controller;

import br.ecommercebagualado.megalojao.dto.UsuariosRequestDTO;
import br.ecommercebagualado.megalojao.model.Usuarios;
import br.ecommercebagualado.megalojao.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuarios>> findAll() {
        List<Usuarios> users = this.repository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public Usuarios findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Usuarios> save (@RequestBody UsuariosRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Usuarios users = new Usuarios();
        users.setNomeCompleto(dto.nome());

        this.repository.save(users);
        return ResponseEntity.ok(users);
    }

}
