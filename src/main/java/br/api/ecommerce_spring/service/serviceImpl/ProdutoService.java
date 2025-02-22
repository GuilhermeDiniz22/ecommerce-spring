package br.api.ecommerce_spring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.ecommerce_spring.entities.Produto;
import br.api.ecommerce_spring.repository.ProdutoRepository;
import br.api.ecommerce_spring.service.IProdutoInterface;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService implements IProdutoInterface {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com id: " + id + " não encontrado!"));
    }

    @Override
    public Produto updateProduto(Produto produto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduto'");
    }

    @Override
    public Produto addProduto(Produto produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPorduto'");
    }

    @Override
    public void removerProduto(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerProduto'");
    }

    @Override
    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> getProdutosByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    @Override
    public List<Produto> getProdutosByNomeAndCategoria(String nome, String categoriaNome) {
        return produtoRepository.findByNomeAndCategoriaNome(nome, categoriaNome);
    }

    @Override
    public List<Produto> getProdutosByCategoria(String categoriaNome) {
        return produtoRepository.findByCategoriaNome(categoriaNome);
    }

    @Override
    public List<Produto> getProdutosByNomeAndMarca(String nome, String marca) {
        return produtoRepository.findByNomeAndMarca(nome, marca);
    }

    @Override
    public List<Produto> getProdutosByMarca(String marca) {
        return produtoRepository.findByMarca(marca);
    }

}
