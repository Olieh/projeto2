package entity;

import java.util.Objects;

public class Item {

    private int id;
    private Produto produto;
    private int qtd;

    // TOSTRING ########################################################################################
    @Override
    public String toString() {
        return "\nItem{" +
                "id=" + id +
                ", produto=" + produto +
                ", qtd=" + qtd +
                '}';
    }

    // EQUALS & HASHCODE ########################################################################################
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && qtd == item.qtd && Objects.equals(produto, item.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produto, qtd);
    }

    // GET & SET ########################################################################################
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
