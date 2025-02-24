package br.api.ecommerce_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.api.ecommerce_spring.entities.Produto;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    boolean existsByNomeContainingIgnoreCase(String nome);

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findByMarcaContainingIgnoreCase(String marca);

    List<Produto> findByCategoriaNomeContainingIgnoreCase(String categoria);

    List<Produto> findByNomeAndCategoriaNomeContainingIgnoreCase(String nome, String nomeCategoria);

    List<Produto> findByNomeAndMarcaContainingIgnoreCase(String nome, String marca);
}
