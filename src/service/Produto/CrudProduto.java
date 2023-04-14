package service.Produto;


import entity.Produto;

import java.util.ArrayList;

public class CrudProduto {
    public ArrayList<Produto> listaProduto;

    public CrudProduto() {
        this.listaProduto = new ArrayList<>();
    }

    public void adicionar(Produto novoProduto) {
        System.out.println("_________________________________________________________________________");
        try {
            if (novoProduto.getNome() == null || novoProduto.getNome().isEmpty() || novoProduto.getPreco() <= 0) {
                System.out.println("Não foi possível adicionar o produto, o nome e o preço devem ser informados.");
                return;
            }
            if (novoProduto.getId() == 0) {
                novoProduto.setId(listaProduto.size() + 1);
            } else {
                for (Produto produto : listaProduto) {
                    if (produto.getId() == novoProduto.getId()) {
                        System.out.println("Já existe um produto com o mesmo id, o produto não foi adicionado.");
                        return;
                    }
                }
            }
            listaProduto.add(novoProduto);
            System.out.println("Produto cadastrado com sucesso!");
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar o produto: " + e.getMessage());
        }
    }


    public void lerUmProduto(int id) {
        for (Produto produto : listaProduto) {
            if (id == produto.getId()) {
                System.out.println(produto);
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    public Produto buscarProduto(int id) {
        for (Produto produto : listaProduto) {
            if (id == produto.getId()) {
                return produto;
            }
        }
        System.out.println("Produto não encontrado!");
        return null;
    }

    public void atualizar(Produto produtoAtualizado) {
        System.out.println("_________________________________________________________________________");
        for (Produto produto : listaProduto) {
            if (produto.getId() == produtoAtualizado.getId()) {
                listaProduto.set(listaProduto.indexOf(produto), produtoAtualizado);
                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    public void deletar(int id) {
        System.out.println("_________________________________________________________________________");
        for (Produto produto : listaProduto) {
            if (id == produto.getId()) {
                listaProduto.remove(produto);
                System.out.println("Produto deletado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    public void listarTodos() {
        System.out.println("_________________________________________________________________________");
        for (Produto produto : listaProduto) {
            System.out.println(produto);
        }
    }

    public void popularLista() {
        Produto produto1 = new Produto();
        produto1.setId(1);
        produto1.setNome("Arroz");
        produto1.setQtdEstoque(10);
        produto1.setPreco(5.99);
        adicionar(produto1);

        Produto produto2 = new Produto();
        produto2.setId(2);
        produto2.setNome("Feijão");
        produto2.setQtdEstoque(5);
        produto2.setPreco(8.99);
        adicionar(produto2);

        Produto produto3 = new Produto();
        produto3.setId(3);
        produto3.setNome("Leite");
        produto3.setQtdEstoque(8);
        produto3.setPreco(3.99);
        adicionar(produto3);

        Produto produto4 = new Produto();
        produto4.setId(4);
        produto4.setNome("Azeite");
        produto4.setQtdEstoque(3);
        produto4.setPreco(9.99);
        adicionar(produto4);

        Produto produto5 = new Produto();
        produto5.setId(5);
        produto5.setNome("Café");
        produto5.setQtdEstoque(12);
        produto5.setPreco(6.99);
        adicionar(produto5);
    }
}
