package Control;

import Bean.Usuario;
import DAO.UsuarioDAO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class EsqueceuSenhaController implements Initializable {

    @FXML
    private TextField campoLogin;
    @FXML
    private TextField campoResposta;
    @FXML
    private TextField campoSenha;
    
    private ObjectProperty<Usuario> userObjProperty = new SimpleObjectProperty();
    private Usuario user;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         userObjProperty.addListener((obs, oldAluno, users) -> {
            if (users != null) {
                //Aqui você preenche seus textfields
                campoSenha.setText(String.valueOf(users.getSenha()));
                }
        });
    } 
    
    @FXML
    private void LembrarSenha(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException, Exception {

        String Login = campoLogin.getText();
        String Resposta = campoResposta.getText();

        if ((campoLogin.getText().isEmpty()) || (campoResposta.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "404 ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            user = UsuarioDAO.verificacaoRespostaSecreta(Login, Resposta);
            userObjProperty.set(user);
        }
    }
    @FXML
    private void Voltar() throws IOException{
         Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/Login.fxml")));
            Main.Principal.myStage.setScene(scene);
    }
}
