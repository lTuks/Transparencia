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
import Bean.Empresa;
import DAO.EmpresaDAO;
import Utils.TextFieldFormatter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.swing.JOptionPane;

public class CadEmpresasController implements Initializable {

    private Empresa Empresa, empresas;
    private Contato contato;
    private ObjectProperty<Empresa> empresaObjProperty = new SimpleObjectProperty();

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
    Label rotuloMatriz;
    @FXML
    TextField campoMatriz;
    @FXML
    Label rotuloRepresentante;
    @FXML
    TextField campoRepresentante;
    @FXML
    Label rotuloValor;
    @FXML
    TextField campoValor;
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
        empresaObjProperty.addListener((obs, oldEmpresa, Empresas) -> {
            if (Empresas != null) {
                //Aqui você preenche seus textfields
                campoCodigo.setText(String.valueOf(Empresas.getCodigo()));
                campoNomeFantasia.setText(Empresas.getNomeFantasia());
                campoCnpj.setText(Empresas.getCnpj());
                campoRazao.setText(Empresas.getRazaoSocial());
                campoInscricao.setText(Empresas.getInscricao());
                campoMatriz.setText(Empresas.getMatriz());
                campoTelefone.setText(Empresas.getContato().getTelefone());
                campoRepresentante.setText(Empresas.getRepresentante());
            }
        });
    }

    @FXML
    private void salvar() {
        this.contato = new Contato(String.valueOf(campoTelefone), "");
        this.Empresa = new Empresa(0, String.valueOf(campoNomeFantasia),
                String.valueOf(campoRazao), String.valueOf(campoCnpj), 
                String.valueOf(campoInscricao), String.valueOf(campoMatriz),
                String.valueOf(campoRepresentante), String.valueOf(campoValor), contato);

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
            Empresa.setValor(campoValor.getText().trim());
        } catch (Exception e) {
            rotuloValor.setTextFill(Paint.valueOf("red"));
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
            rotuloRazao.setTextFill(Paint.valueOf("#008000"));
            rotuloCnpj.setTextFill(Paint.valueOf("#008000"));
            rotuloMatriz.setTextFill(Paint.valueOf("#008000"));
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
    private void pesquisarTransp() throws Exception {
        String nome;
        nome = campoBusca.getText();
        empresas = EmpresaDAO.buscarUm(nome);
        empresaObjProperty.set(empresas);
    }
    @FXML
    private void editar() throws Exception{
        int cod;
        cod = Integer.valueOf(campoCodigo.getText());
        this.contato = new Contato(String.valueOf(campoTelefone), "");
        this.Empresa = new Empresa(0,String.valueOf(campoNomeFantasia), 
                String.valueOf(campoCnpj), String.valueOf(campoRazao), 
                String.valueOf(campoInscricao), String.valueOf(campoMatriz), 
                String.valueOf(campoRepresentante), String.valueOf(campoValor), contato);
        boolean erro = false;
        try {
            Empresa.setNomeFantasia(campoNomeFantasia.getText().trim());
        } catch (Exception e) {
            rotuloNomeFantasia.setTextFill(Paint.valueOf("red"));
            erro = true;
        }       
        try {
            Empresa.setCnpj(campoCnpj.getText());
        } catch (Exception e) {
            rotuloCnpj.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Empresa.setRazaoSocial(campoRazao.getText());
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
            Empresa.setInscricao(campoInscricao.getText());
        } catch (Exception e) {
            rotuloInscricao.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Empresa.setMatriz(campoMatriz.getText());
        } catch (Exception e) {
            rotuloMatriz.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Empresa.setRepresentante(campoRepresentante.getText());
        } catch (Exception e) {
            rotuloRepresentante.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            Empresa.setValor(campoValor.getText());
        } catch (Exception e) {
            rotuloValor.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        if (erro) {
            return;
        }
        try{
            empresas = Empresa;
            EmpresaDAO.alterar(cod, empresas);
            JOptionPane.showMessageDialog(null, "Atualização Efetuada", "CONCLUIDO", JOptionPane.INFORMATION_MESSAGE);;
        } catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Não foi possivel Atualizar", "404 ERROR", JOptionPane.ERROR_MESSAGE);
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
