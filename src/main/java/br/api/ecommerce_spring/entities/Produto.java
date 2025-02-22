package br.api.ecommerce_spring.entities;

import java.math.BigDecimal;
import java.util.Set;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "produto", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Imagem> imagens;

    public Produto() {
    }

    public Produto(Long id, String nome, String marca, BigDecimal preco, String descricao, int quantidade,
            Categoria categoria, List<Imagem> imagens) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.imagens = imagens;
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

    public List<Imagem> getImagens() {
        return this.imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    public Produto id(Long id) {
        setId(id);
        return this;
    }

    public Produto nome(String nome) {
        setNome(nome);
        return this;
    }

    public Produto marca(String marca) {
        setMarca(marca);
        return this;
    }

    public Produto preco(BigDecimal preco) {
        setPreco(preco);
        return this;
    }

    public Produto descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }

    public Produto quantidade(int quantidade) {
        setQuantidade(quantidade);
        return this;
    }

    public Produto categoria(Categoria categoria) {
        setCategoria(categoria);
        return this;
    }

    public Produto imagens(List<Imagem> imagens) {
        setImagens(imagens);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome)
                && Objects.equals(marca, produto.marca) && Objects.equals(preco, produto.preco)
                && Objects.equals(descricao, produto.descricao) && quantidade == produto.quantidade
                && Objects.equals(categoria, produto.categoria) && Objects.equals(imagens, produto.imagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, marca, preco, descricao, quantidade, categoria, imagens);
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
                ", imagens='" + getImagens() + "'" +
                "}";
    }

}
