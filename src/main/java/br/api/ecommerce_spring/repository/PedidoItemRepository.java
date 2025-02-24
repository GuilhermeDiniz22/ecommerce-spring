package br.api.ecommerce_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.api.ecommerce_spring.entities.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

    List<PedidoItem> findByProdutoId(Long produtoId);

}
