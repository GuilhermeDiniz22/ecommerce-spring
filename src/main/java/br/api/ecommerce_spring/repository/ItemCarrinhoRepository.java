package br.api.ecommerce_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.api.ecommerce_spring.entities.ItemCarrinho;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {

    List<ItemCarrinho> findByProdutoId(Long produtoId);
}
