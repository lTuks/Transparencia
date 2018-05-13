package Bean;

public class OrgFomentador {
    
    private int Codigo;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String Inscricao;
    private String Representante;
    private Contato contato;
    
    public OrgFomentador(int Codigo, String nomeFantasia, String razaoSocial, String cnpj, 
            String Inscricao, String Representante, 
            Contato contato){
        this.Codigo = Codigo;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.Inscricao = Inscricao;
        this.Representante = Representante;
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

    public String getRepresentante() {
        return Representante;
    }

    public void setRepresentante(String Representante) {
        this.Representante = Representante;
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
