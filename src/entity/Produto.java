package entity;

import java.util.Objects;

public class Produto {
    private int id;
    private String nome;
    private int qtdEstoque;
    private double preco;

    // TOSTRING ########################################################################################
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", qtdEstoque=" + qtdEstoque +
                ", preco=" + preco +
                '}';
    }

    // EQUALS & HASHCODE ########################################################################################
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id && qtdEstoque == produto.qtdEstoque && Double.compare(produto.preco, preco) == 0 && Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, qtdEstoque, preco);
    }

    // GET & SET ########################################################################################

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
