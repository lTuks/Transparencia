package Control;

import Bean.Usuario;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    TextField campoLogin;
    @FXML
    PasswordField campoSenha;
    @FXML
    Button botaoLogin;
    @FXML
    Button botaoCadastro;
    @FXML
    Label rotuloEsqueceu;
        
    @FXML
    private void acessarMenu(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException, Exception {

        UsuarioDAO dao = new UsuarioDAO();

        String Login = campoLogin.getText();
        String Senha = campoSenha.getText();
        String Nome = "";

        if ((campoLogin.getText().isEmpty()) || (campoSenha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "404 ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Usuario usuario = UsuarioDAO.verificacaoUsuarioLogin(Login, Senha);
            if (usuario != null) {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/Menu.fxml")));
            Main.Principal.myStage.setScene(scene);
            }else {
                JOptionPane.showMessageDialog(null, "Login e/ou Senha Incorretos",
                        "404 ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    @FXML
    private void entrarSenhaClicked() throws IOException{
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/EsqueceuSenha.fxml")));
        Main.Principal.myStage.setScene(scene);
    }
}
