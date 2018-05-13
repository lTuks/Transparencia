package DAO;

import Bean.Contato;
import Bean.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpresaDAO {

    public static void salvar(Empresa empresa) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO Empresa (nomefantasia, razaosocial, CNPJ, "
                + "Inscricao_Estadual, Matriz, Representante, valor, Telefone) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setString(1, empresa.getNomeFantasia());
        ps.setString(2, empresa.getRazaoSocial());
        ps.setString(3, empresa.getCnpj());
        ps.setString(4, empresa.getInscricao());
        ps.setString(5, empresa.getMatriz());
        ps.setString(6, empresa.getRepresentante());
        ps.setString(7, empresa.getValor());
        ps.setString(8, String.valueOf(empresa.getContato().getTelefone()));
        ps.executeUpdate();
    }
    public static void alterar(int Codigo, Empresa empresa) throws Exception {
        Conexao c = new Conexao();
		PreparedStatement ps = c.getConnection().prepareStatement(
                        "UPDATE Empresa SET nomefantasia=?, cnpj=?, razaosocial=?, Inscricao_estadual=?,"
			+ "matriz=?, representante=?, valor =?, Telefone=?"
			+ "WHERE cod_empresa =" + Codigo + "");
		ps.setString(1, empresa.getNomeFantasia());
		ps.setString(2, empresa.getCnpj());
		ps.setString(3, empresa.getRazaoSocial());
		ps.setString(4, empresa.getInscricao());
		ps.setString(5, empresa.getMatriz());
		ps.setString(6, empresa.getRepresentante());
                ps.setString(7, empresa.getValor());
		ps.setString(8, empresa.getContato().getTelefone());
		ps.executeUpdate();
	}
    public static Empresa buscarUm(String nome) throws Exception  {
        Conexao c = new Conexao();
        PreparedStatement ps = null;
        ps = c.getConnection().prepareStatement("SELECT * FROM Empresa WHERE Empresa.nomefantasia ~'^" + nome + "';");
	ResultSet rs = ps.executeQuery();

        Empresa empresa = new Empresa(0, null, null, null, null, null, null, null, null);
        Contato contato = new Contato(null, null);
        while (rs.next()) {
            empresa.setCodigo(rs.getInt("cod_empresa"));
            empresa.setNomeFantasia(rs.getString("nomefantasia"));
            empresa.setCnpj(rs.getString("cnpj"));
            empresa.setRazaoSocial(rs.getString("razaosocial"));
            empresa.setInscricao(rs.getString("inscricao_estadual"));
            empresa.setMatriz(rs.getString("matriz"));
            empresa.setRepresentante(rs.getString("representante"));
            empresa.setValor(rs.getString("valor"));
            contato.setTelefone(rs.getString("Telefone"));
            empresa.setContato(contato);
            
        }
        return empresa;
    }
}
