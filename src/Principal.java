import entity.Produto;
import service.Cliente.CrudClientes;
import service.Item.CrudItem;
import service.Produto.CrudProduto;
import service.venda.CrudVenda;

public class Principal {
    public static void main(String[] args) {
        CrudClientes crudClientes = new CrudClientes();
        crudClientes.popularCliente();

        CrudProduto crudProduto = new CrudProduto();
        crudProduto.popularLista();

        System.out.println("#########################################################################################################");
        System.out.println("TESTE DE - Nao permitir cadastrar um produto sem nome e preço unitario de venda ");
        System.out.println("TESTE DE - sem nome e sem preço");
        Produto produto1 = new Produto();
        produto1.setId(333);
        crudProduto.adicionar(produto1);
        System.out.println("TESTE DE - sem preço");
        produto1.setNome("Paçoquinha");
        crudProduto.adicionar(produto1);
        System.out.println("TESTE DE - sem nome");
        produto1.setNome("");
        produto1.setPreco(99.99);
        System.out.println("#########################################################################################################");


        crudClientes.listarTodos();
        crudClientes.listarTodos();
        crudProduto.listarTodos();

        CrudItem crudItem = new CrudItem();
        crudItem.popularLista(crudProduto);
        crudItem.listarTodos();

        CrudVenda crudVenda = new CrudVenda();
        crudVenda.popularLista(crudClientes,crudProduto,crudItem);
        crudVenda.listarTodos();

        crudVenda.calcularTotal(1);
        crudVenda.listarTodos();

        crudVenda.recibo(1);
    }
}
