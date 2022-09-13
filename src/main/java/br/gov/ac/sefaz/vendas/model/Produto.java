package br.gov.ac.sefaz.vendas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
@NamedQuery(name = "Produto.ProdutosPorCategoria",
        query = "SELECT p FROM Produto p JOIN p.categorias c WHERE c.name = :name")
public class Produto implements Serializable, Base {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false)
    private Double price;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_produto_pedido",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private Set<Pedido> pedidos = new HashSet<>();

    public Produto() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categorias=" + categorias +
                ", pedidos=" + pedidos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
