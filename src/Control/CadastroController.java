package Control;

import Bean.Usuario;
import DAO.UsuarioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javax.swing.JOptionPane;

public class CadastroController implements Initializable {
    
    private Usuario usuario;
    
    @FXML Label rotuloNome;
    @FXML Label rotuloLogin;
    @FXML Label rotuloSenha;
    @FXML TextField campoNome;
    @FXML TextField campoLogin;
    @FXML PasswordField campoSenha;
    @FXML PasswordField campoResposta;
    @FXML Button botaoCadastrar;
    @FXML Button botaoVoltar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    
    public void salvar(){
        
        this.usuario = new Usuario();
        
        usuario.setNome(String.valueOf(campoNome));
        usuario.setLogin(String.valueOf(campoLogin));
        usuario.setSenha(String.valueOf(campoSenha));
        usuario.setResposta(String.valueOf(campoResposta));
        boolean erro = false;
        
        try {
            usuario.setNome(campoNome.getText().trim());
        } catch (Exception e) {
            rotuloNome.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            usuario.setLogin(campoLogin.getText());
        } catch (Exception e) {
            rotuloLogin.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            usuario.setSenha(campoSenha.getText().trim());
        } catch (Exception e) {
            rotuloSenha.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        try {
            usuario.setResposta(campoResposta.getText().trim());
        } catch (Exception e) {
            erro = true;
        }
        try {
            rotuloNome.setTextFill(Paint.valueOf("#008000"));
            rotuloLogin.setTextFill(Paint.valueOf("#008000"));
            rotuloSenha.setTextFill(Paint.valueOf("#008000"));
            UsuarioDAO.salvar(usuario);
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado", "CONCLUIDO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel Cadastrar", "404 ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
