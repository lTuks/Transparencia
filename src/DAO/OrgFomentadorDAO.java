package DAO;

import Bean.Contato;
import Bean.OrgFomentador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public static void alterar(int Codigo, OrgFomentador Org) throws Exception {
        Conexao c = new Conexao();
		PreparedStatement ps = c.getConnection().prepareStatement(
                        "UPDATE Orgfomentador SET nomefantasia=?, cnpj=?, razaosocial=?, Inscricao_estadual=?,"
			+ "representante=?, Telefone=?"
			+ "WHERE cod_orgfomentador =" + Codigo + "");
		ps.setString(1, Org.getNomeFantasia());
		ps.setString(2, Org.getCnpj());
		ps.setString(3, Org.getRazaoSocial());
		ps.setString(4, Org.getInscricao());
		ps.setString(5, Org.getRepresentante());
		ps.setString(6, Org.getContato().getTelefone());
		ps.executeUpdate();
	}
    public static OrgFomentador buscarUm(String nome) throws Exception  {
        Conexao c = new Conexao();
        PreparedStatement ps = null;
        ps = c.getConnection().prepareStatement("SELECT * FROM OrgFomentador "
                + "WHERE OrgFomentador.nomefantasia ~'^" + nome + "';");
	ResultSet rs = ps.executeQuery();

        OrgFomentador Org = new OrgFomentador(0, null, null, null, null, null, null);
        Contato contato = new Contato(null, null);
        while (rs.next()) {
            Org.setCodigo(rs.getInt("cod_Orgfomentador"));
            Org.setNomeFantasia(rs.getString("nomefantasia"));
            Org.setCnpj(rs.getString("cnpj"));
            Org.setRazaoSocial(rs.getString("razaosocial"));
            Org.setInscricao(rs.getString("inscricao_estadual"));
            Org.setRepresentante(rs.getString("representante"));
            contato.setTelefone(rs.getString("Telefone"));
            Org.setContato(contato);
            
        }
        return Org;
    }
}
