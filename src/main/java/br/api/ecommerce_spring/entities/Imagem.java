package br.api.ecommerce_spring.entities;

import java.sql.Blob;
import java.util.Set;

import org.hibernate.annotations.SQLRestriction;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Table(name = "categorias")
@SQLRestriction("ativo = true")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeArquivo;

    @Column(nullable = false)
    private String tipoArquivo;

    @Column(nullable = false)
    @Lob
    private Blob imagem;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Set<Produto> produtos;

    @Column(nullable = false)
    private boolean ativo;

    public Imagem() {
    }

    public Imagem(Long id, String nomeArquivo, String tipoArquivo, Blob imagem, String url, Set<Produto> produtos,
            boolean ativo) {
        this.id = id;
        this.nomeArquivo = nomeArquivo;
        this.tipoArquivo = tipoArquivo;
        this.imagem = imagem;
        this.url = url;
        this.produtos = produtos;
        this.ativo = ativo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeArquivo() {
        return this.nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getTipoArquivo() {
        return this.tipoArquivo;
    }

    public void setTipoArquivo(String tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public Blob getImagem() {
        return this.imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Imagem id(Long id) {
        setId(id);
        return this;
    }

    public Imagem nomeArquivo(String nomeArquivo) {
        setNomeArquivo(nomeArquivo);
        return this;
    }

    public Imagem tipoArquivo(String tipoArquivo) {
        setTipoArquivo(tipoArquivo);
        return this;
    }

    public Imagem imagem(Blob imagem) {
        setImagem(imagem);
        return this;
    }

    public Imagem url(String url) {
        setUrl(url);
        return this;
    }

    public Imagem produtos(Set<Produto> produtos) {
        setProdutos(produtos);
        return this;
    }

    public Imagem ativo(boolean ativo) {
        setAtivo(ativo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Imagem)) {
            return false;
        }
        Imagem imagem = (Imagem) o;
        return Objects.equals(id, imagem.id) && Objects.equals(nomeArquivo, imagem.nomeArquivo)
                && Objects.equals(tipoArquivo, imagem.tipoArquivo) && Objects.equals(imagem, imagem.imagem)
                && Objects.equals(url, imagem.url) && Objects.equals(produtos, imagem.produtos)
                && ativo == imagem.ativo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeArquivo, tipoArquivo, imagem, url, produtos, ativo);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nomeArquivo='" + getNomeArquivo() + "'" +
                ", tipoArquivo='" + getTipoArquivo() + "'" +
                ", imagem='" + getImagem() + "'" +
                ", url='" + getUrl() + "'" +
                ", produtos='" + getProdutos() + "'" +
                ", ativo='" + isAtivo() + "'" +
                "}";
    }

}
