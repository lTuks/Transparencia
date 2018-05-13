package Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import Bean.Aluno;
import Bean.Contato;
import Bean.Endereco;
import DAO.AlunoDAO;
import Utils.TextFieldFormatter;
import javax.swing.JOptionPane;

public class CadAlunoController implements Initializable {

    private Aluno aluno;
    private Contato contato;
    private Endereco endereco;

    @FXML Label rotuloNome;
    @FXML TextField campoNome;
    @FXML Label rotuloCpf;
    @FXML TextField campoCpf;
    @FXML Label rotulorg;
    @FXML TextField campoRg;
    @FXML Label rotuloEmail;
    @FXML TextField campoEmail;
    @FXML Label rotuloTelefone;
    @FXML TextField campoTelefone;
    @FXML Label rotuloInstituicao;
    @FXML TextField campoInstituicao;
    @FXML Label rotuloObservacao;
    @FXML TextArea campoObservacao;
    @FXML Label rotuloRua;
    @FXML TextField campoRua;
    @FXML Label rotuloBairro;
    @FXML TextField campoBairro;
    @FXML Label rotuloCidade;
    @FXML TextField campoCidade;
    @FXML Label rotuloEstado;
    @FXML TextField campoEstado;
    @FXML Label rotuloCep;
    @FXML TextField campoCep;
    @FXML Label rotuloTransporte;
    @FXML TextField campoTransporte;
    @FXML Label rotuloSituacao;
    @FXML CheckBox rotuloAtivo;
    @FXML Button botaoSalvar;
    @FXML Button botaoCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
            AlunoDAO.salvar(aluno);
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado", "CONCLUIDO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel Cadastrar", "404 ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    @FXML
    private void tfCPFKeyRelased(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("1234567890");
        tff.setTf(campoCpf);
        tff.formatter();
    }
    @FXML
    private void tfRGKeyRelased(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###.###-#");
        tff.setCaracteresValidos("0123456789xX");
        tff.setTf(campoRg);
        tff.formatter();
    }
    @FXML
    private void tfTelefoneKeyRelased(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoTelefone);
        tff.formatter();
    }
        @FXML
    private void tfCEPKeyRelased(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#####-###");
        tff.setCaracteresValidos("1234567890");
        tff.setTf(campoCep);
        tff.formatter();
    }
}
