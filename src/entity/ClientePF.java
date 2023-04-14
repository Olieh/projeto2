package entity;

public class ClientePF extends Cliente {
    private Long cpf;


    @Override
    public String toString() {
        return "\nClientePF{" +
                "cpf=" + cpf +
                "} " + super.toString();
    }
    // GET & SET ########################################################################################
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
