package safety.control;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MenuController implements Initializable {

    @FXML
    private TabPane tabPrincipal;
    private ArrayList<String> janelasAbertas = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void abrirAlunos() {
        abrir("/safety/view/Aluno.fxml", "Aluno");
    }

    @FXML
    private void abrirCadAlunos() {
        abrir("/safety/view/CadAluno.fxml", "Cadastro Alunos");
    }

    @FXML
    private void abrirEmpresas() {
        abrir("/safety/view/Empresas.fxml", "Empresas");
    }

    @FXML
    private void abrirCadEmpresas() {
        abrir("/safety/view/CadEmpresas.fxml", "Cadastro Fornecedores");
    }

    private void abrirCadOrgFomentador() {
        abrir("/safety/view/CadOrgFomentador.fxml", "Cadastro Orgão Fomentador");
    }

    private void abrir(String url, String title) {
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
                e.printStackTrace();
            }
        }
    }
}
