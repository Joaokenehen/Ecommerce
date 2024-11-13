package br.ecommercebagualado.megalojao.repository;

import br.ecommercebagualado.megalojao.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
}
