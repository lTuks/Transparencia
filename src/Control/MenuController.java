package Control;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MenuController implements Initializable {

    private ArrayList<String> janelasAbertas = new ArrayList<>();

    @FXML
    Label campoUser;
    @FXML
    private TabPane tabPrincipal;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void abrirRelatorios() {
        abrir("/View/Relatorios.fxml", "Relatórios");
    }

    @FXML
    private void abrirCadAlunos() {
        abrir("/View/CadAluno.fxml", "Cadastro Alunos");
    }

    @FXML
    private void abrirCadEmpresas() {
        abrir("/View/CadEmpresas.fxml", "Cadastro Transportes");
    }

    @FXML
    private void abrirCadOrgFomentador() {
        abrir("/View/CadOrgFomentador.fxml", "Cadastro Orgão Fomentador");
    }

    @FXML
    private void acessarCadastro() {
        abrir("/View/Cadastro.fxml", "Cadastro de Usuários");
    }

    @FXML
    private void sair() throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/Login.fxml")));
        Main.Principal.myStage.setScene(scene);
    }

    void abrir(String url, String title) {
        if (janelasAbertas.contains(title)) {
            JOptionPane.showMessageDialog(null, "Esta janela já está ABERTA!!!", "404 ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            janelasAbertas.add(title);
            try {
                Tab tab = new Tab(title);
                tab.setOnCloseRequest(ev -> {
                    janelasAbertas.remove(tab.getText());
                });
                tab.setContent(new FXMLLoader(getClass().getResource(url)).load());
                tabPrincipal.getTabs().add(tab);
                tabPrincipal.getSelectionModel().select(tab);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
