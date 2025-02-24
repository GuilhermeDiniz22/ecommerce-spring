package br.api.ecommerce_spring.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.ecommerce_spring.dto.request.ProdutoRequest;
import br.api.ecommerce_spring.entities.Carrinho;
import br.api.ecommerce_spring.entities.Categoria;
import br.api.ecommerce_spring.entities.ItemCarrinho;
import br.api.ecommerce_spring.entities.PedidoItem;
import br.api.ecommerce_spring.entities.Produto;
import br.api.ecommerce_spring.repository.CategoriaRepository;
import br.api.ecommerce_spring.repository.ItemCarrinhoRepository;
import br.api.ecommerce_spring.repository.ProdutoRepository;
import br.api.ecommerce_spring.repository.PedidoItemRepository;
import br.api.ecommerce_spring.service.IProdutoInterface;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService implements IProdutoInterface {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Override
    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com id: " + id + " não encontrado!"));
    }

    @Override
    public Produto updateProduto(ProdutoRequest request, Long id) {

        Produto banco = this.getProdutoById(id);

        Produto retorno = this.updateProduto(request, banco);

        return retorno;

    }

    @Override
    public Produto addProduto(ProdutoRequest request) {
        if (produtoRepository.existsByNomeContainingIgnoreCase(request.getNome())) {
            throw new EntityExistsException(
                    "Produto com nome: " + request.getNome() + " já existe no banco de dados.");
        }

        Categoria categoria = Optional.ofNullable(categoriaRepository.findByNome(request.getCategoria().getNome()))
                .orElseGet(() -> {
                    Categoria novaCategoria = new Categoria();
                    novaCategoria.setNome(request.getCategoria().getNome());
                    return categoriaRepository.save(novaCategoria);
                });

        Produto produto = this.criarProduto(request, categoria);

        return produtoRepository.save(produto);
    }

    @Override
    public void removerProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));

        List<ItemCarrinho> items = itemCarrinhoRepository.findByProdutoId(produto.getId());
        for (ItemCarrinho itemCarrinho : items) {
            Carrinho carrinho = itemCarrinho.getCarrinho();
            carrinho.removerItem(itemCarrinho);
            itemCarrinhoRepository.delete(itemCarrinho);
        }

        List<PedidoItem> pedidoItems = pedidoItemRepository.findByProdutoId(id);
        for (PedidoItem pedidoItem : pedidoItems) {
            pedidoItem.setProduto(null);
            pedidoItemRepository.save(pedidoItem);
        }

        Optional.ofNullable(produto.getCategoria())
                .ifPresent(categoria -> categoria.getProdutos().remove(produto));

        produtoRepository.deleteById(produto.getId());
    }

    @Override
    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> getProdutosByNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<Produto> getProdutosByNomeAndCategoria(String nome, String categoriaNome) {
        return produtoRepository.findByNomeAndCategoriaNomeContainingIgnoreCase(nome, categoriaNome);
    }

    @Override
    public List<Produto> getProdutosByCategoria(String categoriaNome) {
        return produtoRepository.findByCategoriaNomeContainingIgnoreCase(categoriaNome);
    }

    @Override
    public List<Produto> getProdutosByNomeAndMarca(String nome, String marca) {
        return produtoRepository.findByNomeAndMarcaContainingIgnoreCase(nome, marca);
    }

    @Override
    public List<Produto> getProdutosByMarca(String marca) {
        return produtoRepository.findByMarcaContainingIgnoreCase(marca);
    }

    private Produto criarProduto(ProdutoRequest produtoRequest, Categoria categoria) {
        Produto novo = new Produto();
        novo.setCategoria(categoria);
        novo.setDescricao(produtoRequest.getDescricao());
        novo.setId(produtoRequest.getId());
        novo.setMarca(produtoRequest.getMarca());
        novo.setNome(produtoRequest.getNome());
        novo.setPreco(produtoRequest.getPreco());
        novo.setQuantidade(produtoRequest.getQuantidade());

        return novo;
    }

    private Produto updateProduto(ProdutoRequest request, Produto produto) {

        produto.setDescricao(request.getDescricao());
        produto.setMarca(request.getMarca());
        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        produto.setCategoria(categoriaRepository.findByNome(request.getCategoria().getNome()));
        produto.setQuantidade(request.getQuantidade());

        return produto;

    }

}
