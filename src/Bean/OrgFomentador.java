package Bean;

public class OrgFomentador {
    
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String Inscricao;
    private String Matriz;
    private String Representante;
    private Endereco enderecoFornecedor;
    private Contato contato;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nome) {
        this.nomeFantasia = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricao() {
        return Inscricao;
    }

    public void setInscricao(String Inscricao) {
        this.Inscricao = Inscricao;
    }

    public String getMatriz() {
        return Matriz;
    }

    public void setMatriz(String Matriz) {
        this.Matriz = Matriz;
    }

    public String getRepresentante() {
        return Representante;
    }

    public void setRepresentante(String Representante) {
        this.Representante = Representante;
    }

    public Endereco getEndereco() {
        return enderecoFornecedor;
    }

    public void setEndereco(Endereco endereco) {
        this.enderecoFornecedor = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return getNomeFantasia();
    }
}
