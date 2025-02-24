package br.api.ecommerce_spring.dto.request;

import java.math.BigDecimal;

import br.api.ecommerce_spring.entities.Categoria;
import java.util.Objects;

public class ProdutoRequest {

    private Long id;

    private String nome;

    private String marca;

    private BigDecimal preco;

    private String descricao;

    private int quantidade;

    private Categoria categoria;

    public ProdutoRequest() {
    }

    public ProdutoRequest(Long id, String nome, String marca, BigDecimal preco, String descricao, int quantidade,
            Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ProdutoRequest id(Long id) {
        setId(id);
        return this;
    }

    public ProdutoRequest nome(String nome) {
        setNome(nome);
        return this;
    }

    public ProdutoRequest marca(String marca) {
        setMarca(marca);
        return this;
    }

    public ProdutoRequest preco(BigDecimal preco) {
        setPreco(preco);
        return this;
    }

    public ProdutoRequest descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }

    public ProdutoRequest quantidade(int quantidade) {
        setQuantidade(quantidade);
        return this;
    }

    public ProdutoRequest categoria(Categoria categoria) {
        setCategoria(categoria);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProdutoRequest)) {
            return false;
        }
        ProdutoRequest produtoRequest = (ProdutoRequest) o;
        return Objects.equals(id, produtoRequest.id) && Objects.equals(nome, produtoRequest.nome)
                && Objects.equals(marca, produtoRequest.marca) && Objects.equals(preco, produtoRequest.preco)
                && Objects.equals(descricao, produtoRequest.descricao) && quantidade == produtoRequest.quantidade
                && Objects.equals(categoria, produtoRequest.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, marca, preco, descricao, quantidade, categoria);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", marca='" + getMarca() + "'" +
                ", preco='" + getPreco() + "'" +
                ", descricao='" + getDescricao() + "'" +
                ", quantidade='" + getQuantidade() + "'" +
                ", categoria='" + getCategoria() + "'" +
                "}";
    }

}
