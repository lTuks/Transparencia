package Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import Bean.Contato;
import Bean.OrgFomentador;
import DAO.OrgFomentadorDAO;
import Utils.TextFieldFormatter;
import javax.swing.JOptionPane;

public class CadOrgFomentadorController implements Initializable {

    private OrgFomentador Org;
    private Contato contato;

    @FXML Label rotuloNomeFantasia;
    @FXML TextField campoNomeFantasia;
    @FXML Label rotuloRazao;
    @FXML TextField campoRazao;
    @FXML Label rotuloCnpj;
    @FXML TextField campoCnpj;
    @FXML Label rotuloInscricao;
    @FXML TextField campoInscricao;
    @FXML Label rotuloRepresentante;
    @FXML TextField campoRepresentante;
    @FXML Label rotuloTelefone;
    @FXML TextField campoTelefone;
    @FXML Button botaoSalvar;
    @FXML Button botaoCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void salvar() {
        this.Org = new OrgFomentador();
        Org.setNomeFantasia(String.valueOf(campoNomeFantasia));
        Org.setRazaoSocial(String.valueOf(campoRazao));
        Org.setCnpj(String.valueOf(campoCnpj));
        Org.setInscricao(String.valueOf(campoInscricao));
        Org.setRepresentante(String.valueOf(campoRepresentante));
        this.contato = new Contato(String.valueOf(campoTelefone), "");
        Org.setContato(contato);

        boolean erro = false;

        try {
            Org.setRazaoSocial(campoRazao.getText().trim());
        } catch (Exception e) {
            rotuloRazao.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Org.setCnpj(campoCnpj.getText());
        } catch (Exception e) {
            rotuloCnpj.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Org.setRepresentante(campoRepresentante.getText().trim());
        } catch (Exception e) {
            rotuloRepresentante.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Org.setNomeFantasia(campoNomeFantasia.getText().trim());
        } catch (Exception e) {
            rotuloNomeFantasia.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Org.setInscricao(campoInscricao.getText().trim());
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
            OrgFomentadorDAO.salvar(Org);
            rotuloRazao.setTextFill(Paint.valueOf("#008000"));
            rotuloCnpj.setTextFill(Paint.valueOf("#008000"));
            rotuloRepresentante.setTextFill(Paint.valueOf("#008000"));
            rotuloInscricao.setTextFill(Paint.valueOf("#008000"));
            rotuloTelefone.setTextFill(Paint.valueOf("#008000"));
            rotuloNomeFantasia.setTextFill(Paint.valueOf("#008000"));
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado", "CONCLUIDO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel Cadastrar", "404 ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    @FXML
    private void tfCNPJKeyRelased(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("########/####-##");
        tff.setCaracteresValidos("1234567890");
        tff.setTf(campoCnpj);
        tff.formatter();
    }
    @FXML
    private void tfInscricaoKeyRelased(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.#####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoInscricao);
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
}
