package service.Item;

import entity.Item;
import entity.Produto;
import service.Produto.CrudProduto;

import java.util.HashMap;
import java.util.Map;

public class CrudItem {
    public Map<Integer, Item> listaItem;

    public CrudItem() {
        this.listaItem = new HashMap<>();
    }

    public void adicionar(Item item, CrudProduto crudProduto) {
        System.out.println("_________________________________________________________________________");
        try {
            int id = listaItem.size();
            item.setId(id);
            if (item.getQtd() > crudProduto.listaProduto.get(item.getProduto().getId()).getQtdEstoque()) {
                System.out.println("Não foi possível adicionar o item, a quantidade em estoque do produto é menor do que a quantidade solicitada.");
                return;
            }
            if (listaItem.containsKey(id)) {
                int novoId = id + 1;
                item.setId(novoId);
                listaItem.put(novoId, item);
                System.out.println("Já existe um item com esse ID, o item foi adicionado com ID " + novoId);
            } else {
                listaItem.put(id, item);
                crudProduto.listaProduto.get(item.getProduto().getId()).setQtdEstoque((crudProduto.listaProduto.get(item.getProduto().getId()).getQtdEstoque()) - (item.getQtd()));
                System.out.println("Item com ID " + id + " cadastrado com sucesso");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar o item: " + e.getMessage());
        }
    }


    public void lerUmProduto(int id) {
        System.out.println("_________________________________________________________________________");
        if (listaItem.containsKey(id)) {
            System.out.println(listaItem.get(id));
        } else {
            System.out.println("Item com o ID " + id + " não encontrado.");
        }
    }

    public void atualizar(Item itemAtualizado) {
        System.out.println("_________________________________________________________________________");
        if (listaItem.containsKey(itemAtualizado.getId())) {
            listaItem.put(itemAtualizado.getId(), itemAtualizado);
            System.out.println("Item atualizado com sucesso!");
        } else {
            System.out.println("Item com ID " + itemAtualizado.getId() + " não encontrado.");
        }
    }

    public void deletar(int id) {
        System.out.println("_________________________________________________________________________");
        if (listaItem.containsKey(id)) {
            listaItem.remove(id);
            System.out.println("Item deletado com sucesso!");
        } else {
            System.out.println("Item não encontrado!");
        }
    }

    public void listarTodos() {
        System.out.println("_________________________________________________________________________");
        for (Map.Entry<Integer, Item> itemDaLista : listaItem.entrySet()) {
            int chave = itemDaLista.getKey();
            Item item = itemDaLista.getValue();
            System.out.println("Chave: " + chave + ", Item: " + item);
        }

    }

    public void popularLista(CrudProduto crudProduto) {
        Produto produto1 = crudProduto.buscarProduto(1);
        Item item1 = new Item();
        item1.setId(1);
        item1.setProduto(produto1);
        item1.setQtd(2);
        adicionar(item1, crudProduto);

        Produto produto2 = crudProduto.buscarProduto(2);
        Item item2 = new Item();
        item2.setId(2);
        item2.setProduto(produto2);
        item2.setQtd(1);
        adicionar(item2, crudProduto);

        Produto produto3 = crudProduto.buscarProduto(3);
        Item item3 = new Item();
        item3.setId(3);
        item3.setProduto(produto3);
        item3.setQtd(3);
        adicionar(item3, crudProduto);

        Produto produto4 = crudProduto.buscarProduto(4);
        Item item4 = new Item();
        item4.setId(4);
        item4.setProduto(produto4);
        item4.setQtd(2);
        adicionar(item4, crudProduto);


    }

}
