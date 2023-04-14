package service.Cliente;

import entity.Cliente;
import entity.ClientePF;

import java.util.ArrayList;

public class CrudClientes implements CrudCliente {
    public ArrayList<Cliente> listaCliente;

    public CrudClientes() {
        listaCliente = new ArrayList<>();
    }

    @Override
    public void adicionar(Cliente cliente) {
        System.out.println("_________________________________________________________________________");
        try {
            int id = listaCliente.size() + 1;
            cliente.setId(id);
            listaCliente.add(cliente);
            System.out.println("Cliente PF criado com sucesso!");
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar o produto: " + e.getMessage());
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
        System.out.println("Cliente PF não encontrado!");
    }

    @Override
    public void atualizar(Cliente cliente) {
        System.out.println("_________________________________________________________________________");
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getId() == cliente.getId()) {
                listaCliente.set(i, cliente);
                System.out.println("Cliente PF atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente PF não encontrado!");
    }

    @Override
    public void deletar(int id) {
        System.out.println("_________________________________________________________________________");
        for (Cliente cliente : listaCliente) {
            if (id == cliente.getId()) {
                listaCliente.remove(cliente);
                System.out.println("Cliente PF deletado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente PF não encontrado!");
    }

    public void listarTodos() {
        System.out.println("_________________________________________________________________________");
        for (Cliente cliente : listaCliente) {
            System.out.println(cliente);
        }
    }

    public void popularClientePF() {
        ClientePF cliente1 = new ClientePF();
        cliente1.setId(1);
        cliente1.setNome("Fulano da Silva");
        cliente1.setCpf(12345678901L);
        adicionar(cliente1);

        ClientePF cliente2 = new ClientePF();
        cliente2.setId(2);
        cliente2.setNome("Beltrano dos Santos");
        cliente2.setCpf(98765432109L);
        adicionar(cliente2);

        ClientePF cliente3 = new ClientePF();
        cliente3.setId(3);
        cliente3.setNome("Ciclano Oliveira");
        cliente3.setCpf(55544433322L);
        adicionar(cliente3);

        ClientePF cliente4 = new ClientePF();
        cliente4.setId(4);
        cliente4.setNome("João das Neves");
        cliente4.setCpf(11122233344L);
        adicionar(cliente4);
    }


}
