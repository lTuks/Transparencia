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
import safety.model.bean.Empresa;
import safety.model.bean.Endereco;
import safety.model.dao.EmpresaDAO;

public class EmpresasController implements Initializable, Controller {

    private Empresa empresa;

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

    @FXML

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEditar.setCellFactory(new BotaoEditar(this));
        colunaEditar.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaExcluir.setCellFactory(new BotaoExcluir(this));
        colunaExcluir.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    }

    @Override
    public void excluir(int codigo) {
        try {
            this.empresa = EmpresaDAO.recuperar(codigo);
            EmpresaDAO.excluir(empresa);
        } catch (Exception e) {
        }
    }

    @Override
    public void editar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
