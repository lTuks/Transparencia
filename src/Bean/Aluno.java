package Bean;

public class Aluno {
    
    private int Codigo;
    private String nome;
    private String cpf;
    private String rg;
    private String instituicao;
    private String observacao;
    private String transporte;
    private String situacao;
    private Endereco endereco;
    private Contato contato;

    public Aluno(int Codigo, String nome, String cpf, String rg, String instituicao, String observacao, String trasnporte, String situacao, Endereco endereco, Contato contato) {
    this.Codigo = Codigo;
    this.nome = nome;
    this.cpf = cpf;
    this.rg = rg;
    this.instituicao =instituicao;
    this.observacao = observacao;
    this.transporte = trasnporte;
    this.situacao = situacao;
    this.endereco = endereco;
    this.contato = contato;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
