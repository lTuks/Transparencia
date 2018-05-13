package DAO;

import Bean.Aluno;
import Bean.Contato;
import Bean.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javafx.collections.FXCollections;

public class AlunoDAO {

    public static void salvar(Aluno aluno) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO Aluno (Nome, Cpf, RG, Instituicao, "
                + "Observacao, Transporte, Situacao, Rua, Bairro, Cidade, Estado, CEP, Telefone, Email) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setString(1, aluno.getNome());
        ps.setString(2, aluno.getCpf());
        ps.setString(3, aluno.getRg());
        ps.setString(4, aluno.getInstituicao());
        ps.setString(5, aluno.getObservacao());
        ps.setString(6, aluno.getTransporte());
        ps.setString(7, aluno.getSituacao());
        ps.setString(8, String.valueOf(aluno.getEndereco().getRua()));
        ps.setString(9, String.valueOf(aluno.getEndereco().getBairro()));
        ps.setString(10, String.valueOf(aluno.getEndereco().getCidade()));
        ps.setString(11, String.valueOf(aluno.getEndereco().getEstado()));
        ps.setString(12, String.valueOf(aluno.getEndereco().getCep()));
        ps.setString(13, String.valueOf(aluno.getContato().getTelefone()));
        ps.setString(14, String.valueOf(aluno.getContato().getEmail()));
        ps.execute();
        ps.close();
    }
    public static void alterar(int Codigo, Aluno aluno) throws Exception {
        Conexao c = new Conexao();
		PreparedStatement ps = c.getConnection().prepareStatement("UPDATE Aluno SET nome=?, Cpf=?, RG=?, Instituicao=?,"
					+ "Observacao=?, Transporte=?, Situacao =?, Rua=?, Bairro=?, Cidade=?, Estado=?, CEP=?, Telefone=?,"
					+ "Email=? WHERE cod_aluno =" + Codigo + "");
		ps.setString(1, aluno.getNome());
		ps.setString(2, aluno.getCpf());
		ps.setString(3, aluno.getRg());
		ps.setString(4, aluno.getInstituicao());
		ps.setString(5, aluno.getObservacao());
		ps.setString(6, aluno.getTransporte());
                ps.setString(7, aluno.getSituacao());
		ps.setString(8, aluno.getEndereco().getRua());
		ps.setString(9, aluno.getEndereco().getBairro());
		ps.setString(10, aluno.getEndereco().getCidade());
		ps.setString(11, aluno.getEndereco().getEstado());
		ps.setString(12, aluno.getEndereco().getCep());
		ps.setString(13, aluno.getContato().getTelefone());
		ps.setString(14, aluno.getContato().getEmail());
		ps.executeUpdate();
                ps.close();
	}
    public static Aluno buscarUm(String nome) throws Exception  {
        Conexao c = new Conexao();
        PreparedStatement ps = null;
        ps = c.getConnection().prepareStatement("SELECT * FROM Aluno WHERE Aluno.nome ~'^" + nome + "';");
	ResultSet rs = ps.executeQuery();

        Aluno aluno = new Aluno(0, null, null, null, null, null, null, null, null, null);
        Endereco endereco = new Endereco(null, null, null, null, null);
        Contato contato = new Contato(null, null);
        while (rs.next()) {
            aluno.setCodigo(rs.getInt("cod_Aluno"));
            aluno.setNome(rs.getString("nome"));
            aluno.setCpf(rs.getString("cpf"));
            aluno.setRg(rs.getString("Rg"));
            aluno.setInstituicao(rs.getString("Instituicao"));
            aluno.setObservacao(rs.getString("Observacao"));
            aluno.setSituacao(rs.getString("Situacao"));
            aluno.setTransporte(rs.getString("Transporte"));
            endereco.setRua(rs.getString("Rua"));
            endereco.setBairro(rs.getString("Bairro"));
            endereco.setCidade(rs.getString("Cidade"));
            endereco.setEstado(rs.getString("Estado"));
            endereco.setCep(rs.getString("CEP"));
            aluno.setEndereco(endereco);
            contato.setTelefone(rs.getString("telefone"));
            contato.setEmail(rs.getString("email"));
            aluno.setContato(contato);           
        }
        ps.close();
        return aluno;
    }
}
