package telaDoFuturo;

import entity.Cliente;
import entity.ClientePF;
import entity.ClientePJ;
import entity.Produto;
import service.Cliente.CrudCliente;

import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalCliente {
    static Scanner leitor;
    static CrudCliente crudCliente;

    public static void main(String[] args) {
        leitor = new Scanner(System.in);

        ArrayList<Cliente> listaCliente = new ArrayList<>();
        populandoListaProduto(listaCliente);
        for (Cliente cliente : listaCliente) {
            System.out.println(cliente);
        }
        // Loop do menu
        while (true) {
            exibirMenu();
            switch (Integer.parseInt(leitor.nextLine())) {
                case 1:
//                    crudCliente.criar(capturaDadosCliente(), listaCliente);
                    break;
                case 2:
//                    System.out.println(crudCliente.lerUmProduto(nomeProcurado(), listaCliente));
                    break;
                case 3:
//                    crudCliente.atualizar(receberProduto(crudCliente.lerUmProduto(nomeProcurado(), listaCliente)), listaCliente);
                    break;
                case 4:
//                    crudCliente.deletar(nomeProcurado(),listaCliente);
                    break;
                case 5:
//                    lerListaProduto(listaCliente);
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

    private static void populandoListaProduto(ArrayList<Cliente> listaProduto) {
        Cliente cliente;
        for (int i = 1; i <= 10; i++) {
            cliente = new ClientePF();
            cliente.setNome("NomeCliente" + i);
            ((ClientePF) cliente).setCpf(100000000l+i);
            listaProduto.add(cliente);
        }
        for (int i = 11; i <= 20; i++) {
            cliente = new ClientePJ();
            cliente.setNome("NomeCliente" + i);
            ((ClientePJ) cliente).setCnpj(20000000000000l+i);
            listaProduto.add(cliente);
        }
    }

    private static void lerListaProduto(ArrayList<Produto> listaProduto) {
        for (Produto produto1 : listaProduto) {
            System.out.println(produto1);
        }
        System.out.println("#####################################");
    }

    private static String nomeProcurado() {
        System.out.println("Informe o nome do produto que deseja manipular:");
        String nomeProduto = leitor.nextLine();
        return nomeProduto;
    }

//    private static Cliente capturaDadosCliente() {
//        Cliente cliente = new Cliente();
//        System.out.println("Informe o nome do cliente:");
//        cliente.setNome(leitor.nextLine());
//        System.out.println("Informe a quantidade do estoque do cliente:");
//        cliente.setQtdEstoque(Integer.parseInt(leitor.nextLine()));
//        System.out.println("Informe o preço do cliente:");
//        cliente.setPreco(Double.parseDouble(leitor.nextLine()));
//
//    }

    private static Produto capturaDadosCliente(Produto produto) {
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
