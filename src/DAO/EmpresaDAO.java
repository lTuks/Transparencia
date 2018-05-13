package DAO;

import Bean.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmpresaDAO {

    public static void salvar(Empresa empresa) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO Empresa (nomefantasia, razaosocial, CNPJ, "
                + "Inscricao_Estadual, Matriz, Representante, Telefone) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setString(1, empresa.getNomeFantasia());
        ps.setString(2, empresa.getRazaoSocial());
        ps.setString(3, empresa.getCnpj());
        ps.setString(4, empresa.getInscricao());
        ps.setString(5, empresa.getMatriz());
        ps.setString(6, empresa.getRepresentante());
        ps.setString(7, String.valueOf(empresa.getContato().getTelefone()));
        ps.executeUpdate();
    }

    public static Empresa recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM EMPRESA WHERE CODIGO=?";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Empresa empresa = new Empresa();
        if (rs.next()) {
            empresa.setNomeFantasia(rs.getString("NOME"));
            empresa.setCnpj(rs.getString("CNPJ"));
        }

        return empresa;
    }
}
