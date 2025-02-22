package br.api.ecommerce_spring.entities;

import java.math.BigDecimal;

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
@Table(name = "pedidos_items")
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal precoUnitario;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public PedidoItem() {
    }

    public PedidoItem(Long id, BigDecimal precoUnitario, int quantidade, Pedido pedido, Produto produto) {
        this.id = id;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoUnitario() {
        return this.precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public PedidoItem id(Long id) {
        setId(id);
        return this;
    }

    public PedidoItem precoUnitario(BigDecimal precoUnitario) {
        setPrecoUnitario(precoUnitario);
        return this;
    }

    public PedidoItem quantidade(int quantidade) {
        setQuantidade(quantidade);
        return this;
    }

    public PedidoItem pedido(Pedido pedido) {
        setPedido(pedido);
        return this;
    }

    public PedidoItem produto(Produto produto) {
        setProduto(produto);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PedidoItem)) {
            return false;
        }
        PedidoItem pedidoItem = (PedidoItem) o;
        return Objects.equals(id, pedidoItem.id) && Objects.equals(precoUnitario, pedidoItem.precoUnitario)
                && quantidade == pedidoItem.quantidade && Objects.equals(pedido, pedidoItem.pedido)
                && Objects.equals(produto, pedidoItem.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, precoUnitario, quantidade, pedido, produto);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", precoUnitario='" + getPrecoUnitario() + "'" +
                ", quantidade='" + getQuantidade() + "'" +
                ", pedido='" + getPedido() + "'" +
                ", produto='" + getProduto() + "'" +
                "}";
    }

}
