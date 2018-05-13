package Control;

import DAO.Conexao;
import Utils.ReportUtils;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import net.sf.jasperreports.engine.JRException;

public class RelatoriosController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void relatorioAlunos(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/Relatorios/Alunos.jasper");
        // mapa de parâmetros do relatório
        Map parametros = new HashMap();
        try {
            // abre o relatório
            ReportUtils.openReport("Alunos", inputStream, parametros,
                    Conexao.getSafetyPlanConnection());
        } catch (SQLException | JRException e) {
        }
    }

    @FXML
    private void relatorioEmpresas(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/Relatorios/Empresas.jasper");
        // mapa de parâmetros do relatório
        Map parametros = new HashMap();
        try {
            // abre o relatório
            ReportUtils.openReport("Empresas", inputStream, parametros,
                    Conexao.getSafetyPlanConnection());
        } catch (SQLException | JRException e) {
        }
    }

    @FXML
    private void relatorioOrgFomentador(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/Relatorios/OrgFomentador.jasper");
        // mapa de parâmetros do relatório
        Map parametros = new HashMap();
        try {
            // abre o relatório
            ReportUtils.openReport("OrgFomentador", inputStream, parametros,
                    Conexao.getSafetyPlanConnection());
        } catch (SQLException | JRException e) {
        }
    }

    @FXML
    private void relatorioEmpresaAlunos(ActionEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/Relatorios/EmpresaAluno.jasper");
        // mapa de parâmetros do relatório
        Map parametros = new HashMap();
        try {
            // abre o relatório
            ReportUtils.openReport("Empresa/Alunos", inputStream, parametros,
                    Conexao.getSafetyPlanConnection());
        } catch (SQLException | JRException e) {
        }
    }

}
