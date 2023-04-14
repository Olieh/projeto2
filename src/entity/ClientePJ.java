package entity;

public class ClientePJ extends Cliente {
    private long cnpj;

    @Override
    public String toString() {
        return "\nClientePJ{" +
                "cnpj=" + cnpj +
                "} " + super.toString();
    }

    // GET & SET ########################################################################################
    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
}
