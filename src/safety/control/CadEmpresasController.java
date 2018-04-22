package safety.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import safety.model.bean.Contato;
import safety.model.bean.Empresa;
import safety.model.dao.EmpresaDAO;

public class CadEmpresasController implements Initializable {

    private Empresa Empresa;
    private Contato contato;

    @FXML
    private Label rotuloNomeFantasia;
    @FXML
    private TextField campoNomeFantasia;
    @FXML
    private Label rotuloRazao;
    @FXML
    private TextField campoRazao;
    @FXML
    private Label rotuloCnpj;
    @FXML
    private TextField campoCnpj;
    @FXML
    private Label rotuloInscricao;
    @FXML
    private TextField campoInscricao;
    @FXML
    private Label rotuloMatriz;
    @FXML
    private TextField campoMatriz;
    @FXML
    private Label rotuloRepresentante;
    @FXML
    private TextField campoRepresentante;
    @FXML
    private Label rotuloTelefone;
    @FXML
    private TextField campoTelefone;
    @FXML
    private Button botaoSalvar;
    @FXML
    private Button botaoCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void salvar() {
        this.Empresa = new Empresa();
        Empresa.setNomeFantasia(String.valueOf(campoNomeFantasia));
        Empresa.setRazaoSocial(String.valueOf(campoRazao));
        Empresa.setCnpj(String.valueOf(campoCnpj));
        Empresa.setInscricao(String.valueOf(campoInscricao));
        Empresa.setMatriz(String.valueOf(campoMatriz));
        Empresa.setRepresentante(String.valueOf(campoRepresentante));
        this.contato = new Contato(String.valueOf(campoTelefone), "");
        Empresa.setContato(contato);

        rotuloRazao.setTextFill(Paint.valueOf("#008000"));
        rotuloCnpj.setTextFill(Paint.valueOf("#008000"));
        rotuloMatriz.setTextFill(Paint.valueOf("#008000"));
        rotuloRepresentante.setTextFill(Paint.valueOf("#008000"));
        rotuloInscricao.setTextFill(Paint.valueOf("#008000"));
        rotuloTelefone.setTextFill(Paint.valueOf("#008000"));
        rotuloNomeFantasia.setTextFill(Paint.valueOf("#008000"));

        boolean erro = false;

        try {
            Empresa.setRazaoSocial(campoRazao.getText().trim());
        } catch (Exception e) {
            rotuloRazao.setTextFill(Paint.valueOf("red"));
            erro = true;
        }

        try {
            Empresa.setCnpj(campoCnpj.getText());
        } catch (Exception e) {
            rotuloCnpj.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Empresa.setMatriz(campoMatriz.getText().trim());
        } catch (Exception e) {
            rotuloMatriz.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Empresa.setRepresentante(campoRepresentante.getText().trim());
        } catch (Exception e) {
            rotuloRepresentante.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Empresa.setNomeFantasia(campoNomeFantasia.getText().trim());
        } catch (Exception e) {
            rotuloNomeFantasia.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Empresa.setInscricao(campoInscricao.getText().trim());
        } catch (Exception e) {
            rotuloInscricao.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            contato.setTelefone(String.valueOf(campoTelefone.getText().trim()));
        } catch (Exception e) {
            rotuloTelefone.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        if (erro) {
            return;
        }
        try {
            EmpresaDAO.salvar(Empresa);
        } catch (Exception e) {
        }
    }

    @FXML
    private void cancelar() {
        botaoCancelar.setOnAction(null);
    }
}
