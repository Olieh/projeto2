package entity;

import java.time.LocalDate;
import java.util.Map;

public class Venda {
    private int id;
    private Cliente cliente;
    private LocalDate data;
    private Map<String, Item>  listaItem;
    private double total;
    // TOSTRING ########################################################################################

    @Override
    public String toString() {
        return "\nVenda{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +
                ", data=" + data +
                ", listaItem=\n" + listaItem +
                ", \ntotal=" + total +
                '}';
    }

    // GET & SET ########################################################################################
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Map<String, Item> getListaItem() {
        return listaItem;
    }

    public void setListaItem(Map<String, Item> listaItem) {
        this.listaItem = listaItem;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
