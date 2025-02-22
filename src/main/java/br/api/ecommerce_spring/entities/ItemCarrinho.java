package br.api.ecommerce_spring.entities;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "items_carrinho")
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private BigDecimal precoUnitario;

    @Column(nullable = false)
    private BigDecimal precoTotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    public void setPrecoTotal() {
        this.precoTotal = this.precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public ItemCarrinho() {
    }

    public ItemCarrinho(Long id, int quantidade, BigDecimal precoUnitario, BigDecimal precoTotal, Produto produto,
            Carrinho carrinho) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = precoTotal;
        this.produto = produto;
        this.carrinho = carrinho;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return this.precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getPrecoTotal() {
        return this.precoTotal;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Carrinho getCarrinho() {
        return this.carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public ItemCarrinho id(Long id) {
        setId(id);
        return this;
    }

    public ItemCarrinho quantidade(int quantidade) {
        setQuantidade(quantidade);
        return this;
    }

    public ItemCarrinho precoUnitario(BigDecimal precoUnitario) {
        setPrecoUnitario(precoUnitario);
        return this;
    }

    public ItemCarrinho produto(Produto produto) {
        setProduto(produto);
        return this;
    }

    public ItemCarrinho carrinho(Carrinho carrinho) {
        setCarrinho(carrinho);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemCarrinho)) {
            return false;
        }
        ItemCarrinho itemCarrinho = (ItemCarrinho) o;
        return Objects.equals(id, itemCarrinho.id) && quantidade == itemCarrinho.quantidade
                && Objects.equals(precoUnitario, itemCarrinho.precoUnitario)
                && Objects.equals(precoTotal, itemCarrinho.precoTotal) && Objects.equals(produto, itemCarrinho.produto)
                && Objects.equals(carrinho, itemCarrinho.carrinho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade, precoUnitario, precoTotal, produto, carrinho);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", quantidade='" + getQuantidade() + "'" +
                ", precoUnitario='" + getPrecoUnitario() + "'" +
                ", precoTotal='" + getPrecoTotal() + "'" +
                ", produto='" + getProduto() + "'" +
                ", carrinho='" + getCarrinho() + "'" +
                "}";
    }

}
