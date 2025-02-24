package br.api.ecommerce_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.api.ecommerce_spring.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByNome(String nome);

}
