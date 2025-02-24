package br.api.ecommerce_spring.service;

import java.util.List;

import br.api.ecommerce_spring.dto.request.ProdutoRequest;
import br.api.ecommerce_spring.entities.Produto;

public interface IProdutoInterface {

   Produto getProdutoById(Long id);

   Produto updateProduto(ProdutoRequest request, Long id);

   Produto addProduto(ProdutoRequest produto);

   void removerProduto(Long id);

   List<Produto> getProdutos();

   List<Produto> getProdutosByNome(String nome);

   List<Produto> getProdutosByNomeAndCategoria(String nome, String categoriaNome);

   List<Produto> getProdutosByCategoria(String categoriaNome);

   List<Produto> getProdutosByNomeAndMarca(String nome, String marca);

   List<Produto> getProdutosByMarca(String marca);

}
