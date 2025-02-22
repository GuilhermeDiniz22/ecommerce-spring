package br.api.ecommerce_spring.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.api.ecommerce_spring.entities.enums.PedidoStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @Column(nullable = false)
    private LocalDate dataPedido;

    @Column(nullable = false)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PedidoItem> pedidosItems = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Long pedidoId, LocalDate dataPedido, BigDecimal total, PedidoStatus pedidoStatus, User user,
            Set<PedidoItem> pedidosItems) {
        this.pedidoId = pedidoId;
        this.dataPedido = dataPedido;
        this.total = total;
        this.pedidoStatus = pedidoStatus;
        this.user = user;
        this.pedidosItems = pedidosItems;
    }

    public Long getPedidoId() {
        return this.pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public LocalDate getDataPedido() {
        return this.dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PedidoStatus getPedidoStatus() {
        return this.pedidoStatus;
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<PedidoItem> getPedidosItems() {
        return this.pedidosItems;
    }

    public void setPedidosItems(Set<PedidoItem> pedidosItems) {
        this.pedidosItems = pedidosItems;
    }

    public Pedido pedidoId(Long pedidoId) {
        setPedidoId(pedidoId);
        return this;
    }

    public Pedido dataPedido(LocalDate dataPedido) {
        setDataPedido(dataPedido);
        return this;
    }

    public Pedido total(BigDecimal total) {
        setTotal(total);
        return this;
    }

    public Pedido pedidoStatus(PedidoStatus pedidoStatus) {
        setPedidoStatus(pedidoStatus);
        return this;
    }

    public Pedido user(User user) {
        setUser(user);
        return this;
    }

    public Pedido pedidosItems(Set<PedidoItem> pedidosItems) {
        setPedidosItems(pedidosItems);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pedido)) {
            return false;
        }
        Pedido pedido = (Pedido) o;
        return Objects.equals(pedidoId, pedido.pedidoId) && Objects.equals(dataPedido, pedido.dataPedido)
                && Objects.equals(total, pedido.total) && Objects.equals(pedidoStatus, pedido.pedidoStatus)
                && Objects.equals(user, pedido.user) && Objects.equals(pedidosItems, pedido.pedidosItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, dataPedido, total, pedidoStatus, user, pedidosItems);
    }

    @Override
    public String toString() {
        return "{" +
                " pedidoId='" + getPedidoId() + "'" +
                ", dataPedido='" + getDataPedido() + "'" +
                ", total='" + getTotal() + "'" +
                ", pedidoStatus='" + getPedidoStatus() + "'" +
                ", user='" + getUser() + "'" +
                ", pedidosItems='" + getPedidosItems() + "'" +
                "}";
    }

}
