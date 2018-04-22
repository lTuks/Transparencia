package safety.model.bean;

public class Empresa {

    private int codigo;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String Inscricao;
    private String Matriz;
    private String Representante;
    private Endereco enderecoFornecedor;
    private Contato contato;

    public Empresa() {
        this.codigo = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Empresa) {
            Empresa c = (Empresa) o;
            if (c.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }

}
