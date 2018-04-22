package safety.control;

import safety.view.component.BotaoEditar;
import safety.view.component.BotaoExcluir;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import safety.model.bean.Aluno;
import safety.model.dao.AlunoDAO;

public class AlunoController implements Initializable, Controller {

    private Aluno aluno;
    @FXML
    private Parent consulta;
    @FXML
    private TableView tabela;
    @FXML
    private TextField filtro;
    @FXML
    private TableColumn colunaNome;
    @FXML
    private TableColumn colunaEditar;
    @FXML
    private TableColumn colunaExcluir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEditar.setCellFactory(new BotaoEditar(this));
        colunaEditar.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaExcluir.setCellFactory(new BotaoExcluir(this));
        colunaExcluir.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    }

    @Override
    public void editar(int codigo) {
        try {
            this.aluno = this.aluno = AlunoDAO.recuperar(codigo);
        } catch (Exception ex) {
        }
    }

    @Override
    public void excluir(int codigo) {
        try {
            this.aluno = AlunoDAO.recuperar(codigo);
            AlunoDAO.excluir(aluno);
        } catch (Exception e) {
        }
    }
}
