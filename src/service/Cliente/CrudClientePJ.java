package service.Cliente;

import entity.Cliente;
import entity.ClientePJ;

import java.util.ArrayList;

public class CrudClientePJ implements CrudCliente {
    public ArrayList<Cliente> listaCliente;

    public CrudClientePJ() {
        listaCliente = new ArrayList<>();
    }

    @Override
    public void adicionar(Cliente cliente) {
        System.out.println("_________________________________________________________________________");
        try {
            int id = listaCliente.size() + 1;
            cliente.setId(id);
            listaCliente.add(cliente);
            System.out.println("Cliente PJ criado com sucesso!");
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar o Cliente: " + e.getMessage());
        }
    }

    @Override
    public void ler(int id) {
        System.out.println("_________________________________________________________________________");
        for (Cliente cliente : listaCliente) {
            if (id == cliente.getId()) {
                System.out.println(cliente);
                return;
            }
        }
        System.out.println("Cliente PJ não encontrado!");
    }

    @Override
    public void atualizar(Cliente cliente) {
        System.out.println("_________________________________________________________________________");
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getId() == cliente.getId()) {
                listaCliente.set(i, cliente);
                System.out.println("Cliente PJ atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente PJ não encontrado!");
    }

    @Override
    public void deletar(int id) {
        System.out.println("_________________________________________________________________________");
        for (Cliente cliente : listaCliente) {
            if (id == cliente.getId()) {
                listaCliente.remove(cliente);
                System.out.println("Cliente PJ deletado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente PJ não encontrado!");
    }

    public void listarTodos() {
        System.out.println("_________________________________________________________________________");
        for (Cliente cliente : listaCliente) {
            System.out.println(cliente);
        }
    }

    public void popularClientePJ() {
        ClientePJ cliente1 = new ClientePJ();
        cliente1.setNome("Empresa A");
        cliente1.setId(1);
        cliente1.setCnpj(12345678901234L);
        adicionar(cliente1);

        ClientePJ cliente2 = new ClientePJ();
        cliente2.setNome("Empresa B");
        cliente2.setId(2);
        cliente2.setCnpj(23456789012345L);
        adicionar(cliente2);

        ClientePJ cliente3 = new ClientePJ();
        cliente3.setNome("Empresa C");
        cliente3.setId(3);
        cliente3.setCnpj(34567890123456L);
        adicionar(cliente3);

        ClientePJ cliente4 = new ClientePJ();
        cliente4.setNome("Empresa D");
        cliente4.setId(4);
        cliente4.setCnpj(45678901234567L);
        adicionar(cliente4);
    }

}
