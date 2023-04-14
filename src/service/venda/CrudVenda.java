package service.venda;

import entity.Item;
import entity.Produto;
import entity.Venda;
import service.Cliente.CrudClientes;
import service.Item.CrudItem;
import service.Produto.CrudProduto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CrudVenda {
    public Map<Integer, Venda> listaVenda;

    public CrudVenda() {
        this.listaVenda = new HashMap<>();
    }

    public void adicionar(Venda novaVenda) {
        System.out.println("_________________________________________________________________________");
        try {
            if (novaVenda.getId() == 0) {
                novaVenda.setId(listaVenda.size() + 1);
            } else {
                for (Venda venda : listaVenda.values()) {
                    if (venda.getId() == novaVenda.getId()) {
                        System.out.println("Já existe uma venda com o mesmo id, a venda não foi adicionada.");
                        return;
                    }
                }
            }
            listaVenda.put(novaVenda.getId(), novaVenda);
            System.out.println("Venda cadastrada com sucesso!");
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar a venda: " + e.getMessage());
        }
    }


    public void calcularTotal(int idVenda) {
        double total = 0.0;
        Map<String, Item> listaItem = buscarVenda(idVenda).getListaItem();
        for (Map.Entry<String, Item> item : listaItem.entrySet()) {
            Produto produto = item.getValue().getProduto();
            double preco = produto.getPreco();
            int quantidade = item.getValue().getQtd();
            double subtotal = quantidade * preco;
            total += subtotal;
        }
        listaVenda.get(idVenda).setTotal(total);
    }

    public Venda buscarVenda(int id) {
        Venda venda = listaVenda.get(id);
        if (venda != null) {
            System.out.println("Venda encontrada: " + venda);
            return venda;
        }
        System.out.println("Venda não encontrada!");
        return null;
    }

    public void atualizar(Venda vendaAtualizada) {
        System.out.println("_________________________________________________________________________");
        Venda venda = listaVenda.get(vendaAtualizada.getId());
        if (venda != null) {
            listaVenda.put(vendaAtualizada.getId(), vendaAtualizada);
            System.out.println("Venda atualizada com sucesso!");
        } else {
            System.out.println("Venda não encontrada!");
        }
    }


    public void deletar(int id) {
        System.out.println("_________________________________________________________________________");
        Venda venda = listaVenda.get(id);
        if (venda != null) {
            listaVenda.remove(id);
            System.out.println("Venda deletada com sucesso!");
        } else {
            System.out.println("Venda não encontrada!");
        }
    }

    public void listarTodos() {
        System.out.println("_________________________________________________________________________");
        for (Venda venda : listaVenda.values()) {
            System.out.println(venda);
        }
    }

    public void popularLista(CrudClientes crudCliente, CrudProduto crudProduto, CrudItem crudItem) {
        Venda venda1 = new Venda();
        venda1.setId(1);
        venda1.setData(LocalDate.now());
        venda1.setCliente(crudCliente.listaCliente.get(1));

        Map<String, Item> listaItem1 = new HashMap<>();
        listaItem1.put(crudProduto.listaProduto.get(1).getNome(), crudItem.listaItem.get(1));
        listaItem1.put(crudProduto.listaProduto.get(2).getNome(), crudItem.listaItem.get(2));
        listaItem1.put(crudProduto.listaProduto.get(3).getNome(), crudItem.listaItem.get(3));
        venda1.setListaItem(listaItem1);
        adicionar(venda1);
    }

    public void recibo(int idVenda) {
        System.out.println("RECIBO ++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("ID da venda: " + idVenda);
        System.out.println("Data da venda: " + listaVenda.get(idVenda).getData());
        System.out.println("Nome do cliente: " + listaVenda.get(idVenda).getCliente().getNome());
        for (Map.Entry<String, Item> itemDaLista : listaVenda.get(idVenda).getListaItem().entrySet()) {
            System.out.println("Produto " + itemDaLista.getValue().getProduto() + " x " + itemDaLista.getValue().getQtd() + " = " + (itemDaLista.getValue().getQtd()) * (itemDaLista.getValue().getProduto().getPreco()));
        }
        System.out.println("Total: " + listaVenda.get(idVenda).getTotal());
    }

}
