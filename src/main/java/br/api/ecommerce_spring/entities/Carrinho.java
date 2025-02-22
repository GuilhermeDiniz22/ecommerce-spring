package br.api.ecommerce_spring.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "carrinhos")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal total;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemCarrinho> itemCarrinho = new HashSet<>();

    public Carrinho() {
    }

    public Carrinho(Long id, BigDecimal total, User user, Set<ItemCarrinho> itemCarrinho) {
        this.id = id;
        this.total = total;
        this.user = user;
        this.itemCarrinho = itemCarrinho;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ItemCarrinho> getItemCarrinho() {
        return this.itemCarrinho;
    }

    public void setItemCarrinho(Set<ItemCarrinho> itemCarrinho) {
        this.itemCarrinho = itemCarrinho;
    }

    public Carrinho id(Long id) {
        setId(id);
        return this;
    }

    public Carrinho total(BigDecimal total) {
        setTotal(total);
        return this;
    }

    public Carrinho user(User user) {
        setUser(user);
        return this;
    }

    public Carrinho itemCarrinho(Set<ItemCarrinho> itemCarrinho) {
        setItemCarrinho(itemCarrinho);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Carrinho)) {
            return false;
        }
        Carrinho carrinho = (Carrinho) o;
        return Objects.equals(id, carrinho.id) && Objects.equals(total, carrinho.total)
                && Objects.equals(user, carrinho.user) && Objects.equals(itemCarrinho, carrinho.itemCarrinho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, user, itemCarrinho);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", total='" + getTotal() + "'" +
                ", user='" + getUser() + "'" +
                ", itemCarrinho='" + getItemCarrinho() + "'" +
                "}";
    }

}
