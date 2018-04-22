package safety.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import safety.model.bean.Aluno;
import safety.model.bean.Contato;
import safety.model.bean.Endereco;
import safety.model.dao.AlunoDAO;

public class CadAlunoController implements Initializable, Controller {

    private Aluno aluno;
    private Contato contato;
    private Endereco endereco;

    @FXML
    private Label rotuloNome;
    @FXML
    private TextField campoNome;
    @FXML
    private Label rotuloCpf;
    @FXML
    private TextField campoCpf;
    @FXML
    private Label rotulorg;
    @FXML
    private TextField campoRg;
    @FXML
    private Label rotuloEmail;
    @FXML
    private TextField campoEmail;
    @FXML
    private Label rotuloTelefone;
    @FXML
    private TextField campoTelefone;
    @FXML
    private Label rotuloInstituicao;
    @FXML
    private TextField campoInstituicao;
    @FXML
    private Label rotuloObservacao;
    @FXML
    private TextArea campoObservacao;
    @FXML
    private Label rotuloRua;
    @FXML
    private TextField campoRua;
    @FXML
    private Label rotuloBairro;
    @FXML
    private TextField campoBairro;
    @FXML
    private Label rotuloCidade;
    @FXML
    private TextField campoCidade;
    @FXML
    private Label rotuloEstado;
    @FXML
    private TextField campoEstado;
    @FXML
    private Label rotuloCep;
    @FXML
    private TextField campoCep;
    @FXML
    private Label rotuloTransporte;
    @FXML
    private TextField campoTransporte;
    @FXML
    private Label rotuloSituacao;
    @FXML
    private CheckBox rotuloAtivo;
    @FXML
    private Button botaoSalvar;
    @FXML
    private Button botaoCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void editar(int codigo) {
        try {
            this.aluno = this.aluno = AlunoDAO.recuperar(codigo);
        } catch (Exception ex) {
            return;
        }
        campoNome.setText(aluno.getNome());
        campoCpf.setText(aluno.getCpf());
        campoRg.setText(aluno.getRg());
        campoEmail.setText(contato.getEmail());
        campoTelefone.setText(contato.getTelefone());
        campoInstituicao.setText(aluno.getInstituicao());
        campoObservacao.setText(aluno.getObservacao());
        campoRua.setText(endereco.getRua());
        campoBairro.setText(endereco.getBairro());
        campoCidade.setText(endereco.getCidade());
        campoEstado.setText(endereco.getEstado());
        campoCep.setText(String.valueOf(endereco.getCep()));
        campoTransporte.setText(aluno.getTransporte());
    }

    @Override
    public void excluir(int codigo) {
        try {
            this.aluno = AlunoDAO.recuperar(codigo);
            AlunoDAO.excluir(aluno);
        } catch (Exception e) {
            return;
        }
    }

    @FXML
    private void salvar() {
        this.endereco = new Endereco(String.valueOf(campoRua), String.valueOf(campoBairro), String.valueOf(campoCidade), String.valueOf(campoEstado), String.valueOf(campoCep));
        this.contato = new Contato(String.valueOf(campoEmail), String.valueOf(campoTelefone));
        aluno = new Aluno();
        aluno.setNome(String.valueOf(campoNome));
        aluno.setCpf(String.valueOf(campoCpf));
        aluno.setRg(String.valueOf(campoRg));
        aluno.setInstituicao(String.valueOf(campoInstituicao));
        aluno.setObservacao(String.valueOf(campoObservacao));
        aluno.setTransporte(String.valueOf(campoTransporte));
        aluno.setEndereco(endereco);
        aluno.setContato(contato);

        rotuloNome.setTextFill(Paint.valueOf("#008000"));
        rotuloCpf.setTextFill(Paint.valueOf("#008000"));
        rotulorg.setTextFill(Paint.valueOf("#008000"));
        rotuloEmail.setTextFill(Paint.valueOf("#008000"));
        rotuloTelefone.setTextFill(Paint.valueOf("#008000"));
        rotuloInstituicao.setTextFill(Paint.valueOf("#008000"));
        rotuloObservacao.setTextFill(Paint.valueOf("#008000"));
        rotuloRua.setTextFill(Paint.valueOf("#008000"));
        rotuloBairro.setTextFill(Paint.valueOf("#008000"));
        rotuloCidade.setTextFill(Paint.valueOf("#008000"));
        rotuloEstado.setTextFill(Paint.valueOf("#008000"));
        rotuloCep.setTextFill(Paint.valueOf("#008000"));
        rotuloTransporte.setTextFill(Paint.valueOf("#008000"));
        boolean erro = false;

        try {
            aluno.setNome(campoNome.getText().trim());
        } catch (Exception e) {
            rotuloNome.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            aluno.setCpf(campoCpf.getText());
        } catch (Exception e) {
            rotuloCpf.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            aluno.setRg(campoRg.getText());
        } catch (Exception e) {
            rotulorg.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            contato.setEmail(campoEmail.getText());
        } catch (Exception e) {
            rotuloEmail.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            contato.setTelefone(String.valueOf(campoTelefone.getText()));
        } catch (Exception e) {
            rotuloTelefone.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            aluno.setInstituicao(campoInstituicao.getText());
        } catch (Exception e) {
            rotuloInstituicao.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            aluno.setObservacao(campoObservacao.getText());
        } catch (Exception e) {
            rotuloObservacao.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            endereco.setRua(campoRua.getText());
        } catch (Exception e) {
            rotuloRua.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            endereco.setBairro(campoBairro.getText());
        } catch (Exception e) {
            rotuloBairro.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            endereco.setCidade(campoCidade.getText());
        } catch (Exception e) {
            rotuloCidade.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            endereco.setEstado(campoEstado.getText());
        } catch (Exception e) {
            rotuloEstado.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            endereco.setCep(String.valueOf(campoCep.getText()));
        } catch (Exception e) {
            rotuloCep.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            aluno.setTransporte(campoTransporte.getText());
        } catch (Exception e) {
            rotuloTransporte.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        if (erro) {
            return;
        }

        try {
            AlunoDAO.salvar(aluno);
        } catch (Exception e) {
        }
    }

    @FXML
    private void cancelar() {
        botaoCancelar.setOnAction(null);
    }
}
