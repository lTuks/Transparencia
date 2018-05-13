package DAO;

import Bean.OrgFomentador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrgFomentadorDAO {

    public static void salvar(OrgFomentador Org) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO OrgFomentador (nomefantasia, razaosocial, CNPJ, "
                + "Inscricao_Estadual, Representante, Telefone) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setString(1, Org.getNomeFantasia());
        ps.setString(2, Org.getRazaoSocial());
        ps.setString(3, Org.getCnpj());
        ps.setString(4, Org.getInscricao());
        ps.setString(5, Org.getRepresentante());
        ps.setString(6, String.valueOf(Org.getContato().getTelefone()));
        ps.executeUpdate();
    }

    public static int quantidade(String filtro) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT COUNT(1) FROM OrgFomentador WHERE NOME LIKE ?";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public static ObservableList<OrgFomentador> listar(String filtro, int quantidade, int pagina) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM OrgFomentador WHERE NOME LIKE ? "
                + "ORDER BY NOME LIMIT ?,?";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ps.setInt(2, pagina * quantidade);
        ps.setInt(3, quantidade);
        ResultSet rs = ps.executeQuery();
        ObservableList listaOrg = FXCollections.observableArrayList();
        while (rs.next()) {
            OrgFomentador Org = new OrgFomentador();
            Org.setNomeFantasia(rs.getString("NOME"));
            Org.setCnpj(rs.getString("CNPJ"));
            Org.setRazaoSocial(rs.getString("RAZAO"));
            Org.setInscricao(rs.getString("INSCRICAO"));
            Org.setRepresentante(rs.getString("REPRESENTANTE"));
            listaOrg.add(Org);
        }

        return listaOrg;
    }

    public static OrgFomentador recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM OrgFomentador WHERE CODIGO=?";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        OrgFomentador Org = new OrgFomentador();
        if (rs.next()) {
            Org.setNomeFantasia(rs.getString("NOME"));
            Org.setCnpj(rs.getString("CNPJ"));
        }

        return Org;
    }
}
