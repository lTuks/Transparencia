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
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.swing.JOptionPane;

public class CadAlunoController implements Initializable {

    private Aluno aluno, alunos;
    private Contato contato;
    private Endereco endereco;
    private ObjectProperty<Aluno> alunoObjProperty = new SimpleObjectProperty();

    @FXML
    public TextField campoCodigo;
    @FXML
    public TextField campoBusca;
    @FXML
    public Label rotuloNome;
    @FXML
    public TextField campoNome;
    @FXML
    public Label rotuloCpf;
    @FXML
    public TextField campoCpf;
    @FXML
    public Label rotulorg;
    @FXML
    public TextField campoRg;
    @FXML
    public Label rotuloEmail;
    @FXML
    public TextField campoEmail;
    @FXML
    public Label rotuloTelefone;
    @FXML
    public TextField campoTelefone;
    @FXML
    public Label rotuloInstituicao;
    @FXML
    public TextField campoInstituicao;
    @FXML
    public Label rotuloObservacao;
    @FXML
    public TextArea campoObservacao;
    @FXML
    public Label rotuloRua;
    @FXML
    public TextField campoRua;
    @FXML
    public Label rotuloBairro;
    @FXML
    public TextField campoBairro;
    @FXML
    public Label rotuloCidade;
    @FXML
    public TextField campoCidade;
    @FXML
    public Label rotuloEstado;
    @FXML
    public TextField campoEstado;
    @FXML
    public Label rotuloCep;
    @FXML
    public TextField campoCep;
    @FXML
    public Label rotuloTransporte;
    @FXML
    public TextField campoTransporte;
    @FXML
    public Label rotuloSituacao;
    @FXML
    public TextField campoSituacao;
    @FXML
    public Button botaoSalvar;
    @FXML
    public Button botaoCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alunoObjProperty.addListener((obs, oldAluno, alunos) -> {
            if (alunos != null) {
                //Aqui você preenche seus textfields
                campoCodigo.setText(String.valueOf(alunos.getCodigo()));
                campoNome.setText(alunos.getNome());
                campoCpf.setText(alunos.getCpf());
                campoRg.setText(alunos.getRg());
                campoInstituicao.setText(alunos.getInstituicao());
                campoObservacao.setText(alunos.getObservacao());
                campoTransporte.setText(alunos.getTransporte());
                campoSituacao.setText(alunos.getSituacao());
                campoRua.setText(alunos.getEndereco().getRua());
                campoBairro.setText(alunos.getEndereco().getBairro());
                campoCidade.setText(alunos.getEndereco().getCidade());
                campoEstado.setText(alunos.getEndereco().getEstado());
                campoCep.setText(alunos.getEndereco().getCep());
                campoEmail.setText(alunos.getContato().getEmail());
                campoTelefone.setText(alunos.getContato().getTelefone());
            }
        });
    }

    @FXML
    private void salvar() {
        this.endereco = new Endereco(String.valueOf(campoRua),
                String.valueOf(campoBairro), String.valueOf(campoCidade),
                String.valueOf(campoEstado), String.valueOf(campoCep));
        this.contato = new Contato(String.valueOf(campoEmail),
                String.valueOf(campoTelefone));
        aluno = new Aluno(0, String.valueOf(campoNome), String.valueOf(campoCpf),
                String.valueOf(campoRg), String.valueOf(campoInstituicao),
                String.valueOf(campoObservacao), String.valueOf(campoTransporte),
                String.valueOf(campoSituacao), endereco, contato);
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
            aluno.setSituacao(campoSituacao.getText());
        } catch (Exception e) {
            rotuloSituacao.setTextFill(Paint.valueOf("red"));
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
            rotuloSituacao.setTextFill(Paint.valueOf("#008000"));
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
        }
    }

    @FXML
    private void pesquisarAluno() throws Exception {
        String nome = campoBusca.getText();
        alunos = AlunoDAO.buscarUm(nome);
        alunoObjProperty.set(alunos);
    }

    @FXML
    private void editar() throws Exception {
        int cod;
        cod = Integer.valueOf(campoCodigo.getText());
        this.endereco = new Endereco(String.valueOf(campoRua),
                String.valueOf(campoBairro), String.valueOf(campoCidade),
                String.valueOf(campoEstado), String.valueOf(campoCep));
        this.contato = new Contato(String.valueOf(campoEmail),
                String.valueOf(campoTelefone));
        this.aluno = new Aluno(0, String.valueOf(campoNome), String.valueOf(campoCpf),
                String.valueOf(campoRg), String.valueOf(campoInstituicao),
                String.valueOf(campoObservacao), String.valueOf(campoTransporte),
                String.valueOf(campoSituacao), endereco, contato);
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
            aluno.setSituacao(campoSituacao.getText());
        } catch (Exception e) {
            rotuloSituacao.setTextFill(Paint.valueOf("red"));
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
            alunos = aluno;
            AlunoDAO.alterar(cod, alunos);
            JOptionPane.showMessageDialog(null, "Atualização Efetuada", "CONCLUIDO", JOptionPane.INFORMATION_MESSAGE);;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel Atualizar", "404 ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void tfCPFKeyRelased() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoCpf);
        tff.formatter();
    }

    @FXML
    private void tfRGKeyRelased() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###.###-#");
        tff.setCaracteresValidos("0123456789xX");
        tff.setTf(campoRg);
        tff.formatter();
    }

    @FXML
    private void tfTelefoneKeyRelased() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoTelefone);
        tff.formatter();
    }

    @FXML
    private void tfCEPKeyRelased() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#####-###");
        tff.setCaracteresValidos("1234567890");
        tff.setTf(campoCep);
        tff.formatter();
    }
}
