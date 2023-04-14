package service.Cliente;

import entity.Cliente;

public interface CrudCliente {
    public void adicionar(Cliente cliente);
    public void ler(int id);
    public void atualizar(Cliente cliente);
    public void deletar(int id);
}
