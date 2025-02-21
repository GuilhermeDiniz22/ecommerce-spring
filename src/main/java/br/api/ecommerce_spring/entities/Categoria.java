package br.api.ecommerce_spring.entities;

import java.util.Set;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "categorias")
@SQLRestriction("ativo = true")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private Set<Produto> produtos;

    @Column(nullable = false)
    private boolean ativo;

    public Categoria() {
    }

    public Categoria(Long id, String nome, Set<Produto> produtos, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
        this.ativo = ativo;
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

    public Set<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Categoria id(Long id) {
        setId(id);
        return this;
    }

    public Categoria nome(String nome) {
        setNome(nome);
        return this;
    }

    public Categoria produtos(Set<Produto> produtos) {
        setProdutos(produtos);
        return this;
    }

    public Categoria ativo(boolean ativo) {
        setAtivo(ativo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Categoria)) {
            return false;
        }
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(nome, categoria.nome)
                && Objects.equals(produtos, categoria.produtos) && ativo == categoria.ativo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, produtos, ativo);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", produtos='" + getProdutos() + "'" +
                ", ativo='" + isAtivo() + "'" +
                "}";
    }

}
