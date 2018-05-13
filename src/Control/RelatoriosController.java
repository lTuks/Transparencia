package Control;

import DAO.Conexao;
import Utils.ReportUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;

public class RelatoriosController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    Label rotuloAluno;
    @FXML
    Label rotuloEmpresa;
    @FXML
    Label rotuloOrgFom;
    @FXML
    TextField campoAluno;
    @FXML
    TextField campoEmpresa;
    @FXML
    TextField campoOrgFom;

    @FXML
    void relatorioAlunos() throws IOException, SQLException {
        InputStream inputStream = getClass().getResourceAsStream("/Relatorios/Alunos.jasper");
        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();
        try {
            // abre o relatório
            ReportUtils.openReport("Alunos", inputStream, parametros,
                    Conexao.getSafetyPlanConnection());
        } catch (JRException exc) {
        }
    }

    @FXML
    void relatorioEmpresas() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/Relatorios/Empresas.jasper");
        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();
        try {
            // abre o relatório
            ReportUtils.openReport("Empresas", inputStream, parametros,
                    Conexao.getSafetyPlanConnection());
        } catch (SQLException | JRException exc) {
        }
    }

    @FXML
    void relatorioOrgFomentador() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/Relatorios/OrgFomentador.jasper");
        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();
        try {
            // abre o relatório
            ReportUtils.openReport("Orgão Fomentador", inputStream, parametros,
                    Conexao.getSafetyPlanConnection());
        } catch (SQLException | JRException exc) {
        }
    }
}
