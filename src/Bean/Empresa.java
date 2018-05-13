package Bean;

public class Empresa {
    
    private int Codigo;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String Inscricao;
    private String Matriz;
    private String Representante;
    private String Valor;
    private Contato contato;

    public Empresa(int Codigo, String nomeFantasia, String razaoSocial, String cnpj, 
            String Inscricao, String Matriz, String Representante, String Valor,
            Contato contato){
        this.Codigo = Codigo;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.Inscricao = Inscricao;
        this.Matriz = Matriz;
        this.Representante = Representante;
        this.Valor = Valor;
        this.contato = contato;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
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

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
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
