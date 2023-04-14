package telaDoFuturo;

import entity.Produto;
import service.Produto.CrudProduto;

import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalProduto {
    static Scanner leitor;
    static CrudProduto crudProduto;

    public static void main(String[] args) {
        leitor = new Scanner(System.in);
        crudProduto = new CrudProduto();
        ArrayList<Produto> listaProduto = new ArrayList<>();
        populandoListaProduto(listaProduto);
        // Loop do menu
        while (true) {
            exibirMenu();
            switch (Integer.parseInt(leitor.nextLine())) {
                case 1:
                    crudProduto.adicionar(capturaDadosProduto());
                    break;
                case 2:
                    crudProduto.lerUmProduto(idProdutoProcurado());
                    break;
                case 3:
                    crudProduto.atualizar(capturaDadosProduto(idProdutoProcurado()));
                    break;
                case 4:
                    crudProduto.deletar(idProdutoProcurado());
                    break;
                case 5:
                    lerListaProduto(listaProduto);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    leitor.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void populandoListaProduto(ArrayList<Produto> listaProduto) {
        Produto produto;
        for (int i = 1; i <= 10; i++) {
            produto = new Produto();
            produto.setNome("Nome" + i);
            produto.setQtdEstoque(i);
            produto.setPreco(i * 10.01);
            listaProduto.add(produto);
        }
    }

    private static void lerListaProduto(ArrayList<Produto> listaProduto) {
        for (Produto produto1 : listaProduto) {
            System.out.println(produto1);
        }
        System.out.println("#####################################");
    }

    private static int idProdutoProcurado() {
        System.out.println("Informe o nome do produto que deseja manipular:");
        int idProduto = Integer.parseInt(leitor.nextLine());
        return idProduto;
    }

    private static Produto capturaDadosProduto() {
        Produto produto = new Produto();
        System.out.println("Informe o nome do produto:");
        produto.setNome(leitor.nextLine());
        System.out.println("Informe a quantidade do estoque do produto:");
        produto.setQtdEstoque(Integer.parseInt(leitor.nextLine()));
        System.out.println("Informe o preço do produto:");
        produto.setPreco(Double.parseDouble(leitor.nextLine()));
        return produto;
    }

    private static Produto capturaDadosProduto(int id) {
        Produto produto = null;
        for (Produto produtoProcurado : crudProduto.listaProduto) {
            if (produtoProcurado.getId() == id) {
                produto = produtoProcurado;
            }
        }
        System.out.println("Informe o nome do produto:");
        System.out.println("Nome atual [" + produto.getNome() + "]");
        produto.setNome(leitor.nextLine());
        System.out.println("Informe a quantidade do produto:");
        System.out.println("Quantidade atual [" + produto.getQtdEstoque() + "]");
        produto.setQtdEstoque(Integer.parseInt(leitor.nextLine()));
        System.out.println("Informe o preço do produto:");
        System.out.println("Preco atual [" + produto.getPreco() + "]");
        produto.setPreco(Double.parseDouble(leitor.nextLine()));
        return produto;
    }

    public static void exibirMenu() {
        System.out.println("====== Produto ======");
        System.out.println("[1] - Cadastrar");
        System.out.println("[2] - Ler");
        System.out.println("[3] - Atualizar");
        System.out.println("[4] - Deletar");
        System.out.println("[5] - Listar todos os produtos");
        System.out.println("[0] - Sair");
        System.out.println("====== Produto ======");
        System.out.println("Informe o numero da opção que deseja selecionar:");
    }

}
