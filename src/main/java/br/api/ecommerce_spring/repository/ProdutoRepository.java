package br.api.ecommerce_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.api.ecommerce_spring.entities.Categoria;
import br.api.ecommerce_spring.entities.Produto;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);

    List<Produto> findByMarca(String marca);

    List<Produto> findByCategoriaNome(String categoria);

    List<Produto> findByNomeAndCategoriaNome(String nome, String nomeCategoria);

    List<Produto> findByNomeAndMarca(String nome, String marca);
}
