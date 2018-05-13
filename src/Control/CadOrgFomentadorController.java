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
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.swing.JOptionPane;

public class CadOrgFomentadorController implements Initializable {

    private OrgFomentador Org, Orgs;
    private Contato contato;
    private ObjectProperty<OrgFomentador> orgObjProperty = new SimpleObjectProperty();
    
    @FXML
    TextField campoCodigo;
    @FXML
    TextField campoBusca;
    @FXML
    Label rotuloNomeFantasia;
    @FXML
    TextField campoNomeFantasia;
    @FXML
    Label rotuloRazao;
    @FXML
    TextField campoRazao;
    @FXML
    Label rotuloCnpj;
    @FXML
    TextField campoCnpj;
    @FXML
    Label rotuloInscricao;
    @FXML
    TextField campoInscricao;
    @FXML
    Label rotuloRepresentante;
    @FXML
    TextField campoRepresentante;
    @FXML
    Label rotuloTelefone;
    @FXML
    TextField campoTelefone;
    @FXML
    Button botaoSalvar;
    @FXML
    Button botaoCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orgObjProperty.addListener((obs, oldOrgs, orgs) -> {
            if (orgs != null) {
                //Aqui você preenche seus textfields
                campoCodigo.setText(String.valueOf(orgs.getCodigo()));
                campoCodigo.setText(String.valueOf(orgs.getCodigo()));
                campoNomeFantasia.setText(orgs.getNomeFantasia());
                campoCnpj.setText(orgs.getCnpj());
                campoRazao.setText(orgs.getRazaoSocial());
                campoInscricao.setText(orgs.getInscricao());
                campoTelefone.setText(orgs.getContato().getTelefone());
                campoRepresentante.setText(orgs.getRepresentante());
            }
        });

    }

    @FXML
    private void salvar() {
        this.contato = new Contato(String.valueOf(campoTelefone), "");
        this.Org = new OrgFomentador(0, String.valueOf(campoNomeFantasia),
                String.valueOf(campoRazao), String.valueOf(campoCnpj),
                String.valueOf(campoInscricao),
                String.valueOf(campoRepresentante), contato);
        
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
    private void pesquisarOrgFomentador() throws Exception {
        String nome;
        nome = campoBusca.getText();
        Orgs = OrgFomentadorDAO.buscarUm(nome);
        orgObjProperty.set(Orgs);
    }
    @FXML
     private void editarOrgFomentador() throws Exception{
        int cod;
        cod = Integer.valueOf(campoCodigo.getText());
        this.contato = new Contato(String.valueOf(campoTelefone), "");
        this.Org = new OrgFomentador(0,String.valueOf(campoNomeFantasia), 
                String.valueOf(campoCnpj), String.valueOf(campoRazao), 
                String.valueOf(campoInscricao),String.valueOf(campoRepresentante),
                contato);
        boolean erro = false;
        try {
            Org.setNomeFantasia(campoNomeFantasia.getText().trim());
        } catch (Exception e) {
            rotuloNomeFantasia.setTextFill(Paint.valueOf("red"));
            erro = true;
        }       
        try {
            Org.setCnpj(campoCnpj.getText());
        } catch (Exception e) {
            rotuloCnpj.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Org.setRazaoSocial(campoRazao.getText());
        } catch (Exception e) {
            rotuloRazao.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            contato.setTelefone(String.valueOf(campoTelefone.getText()));
        } catch (Exception e) {
            rotuloTelefone.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Org.setInscricao(campoInscricao.getText());
        } catch (Exception e) {
            rotuloInscricao.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Org.setRepresentante(campoRepresentante.getText());
        } catch (Exception e) {
            rotuloRepresentante.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        if (erro) {
            return;
        }
        try{
            Orgs = Org;
            OrgFomentadorDAO.alterar(cod, Orgs);
            JOptionPane.showMessageDialog(null, "Atualização Efetuada", "CONCLUIDO", JOptionPane.INFORMATION_MESSAGE);;
        } catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Não foi possivel Atualizar", "404 ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }    
    }
    @FXML
    private void tfCNPJKeyRelased() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("########/####-##");
        tff.setCaracteresValidos("1234567890");
        tff.setTf(campoCnpj);
        tff.formatter();
    }

    @FXML
    private void tfInscricaoKeyRelased() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.#####-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoInscricao);
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
}
