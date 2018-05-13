package DAO;

import Bean.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoDAO {

    public static void salvar(Aluno aluno) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO Aluno (Nome, Cpf, RG, Instituicao, "
                + "Observacao, Transporte, Rua, Bairro, Cidade, Estado, CEP, Telefone, Email) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setString(1, aluno.getNome());
        ps.setString(2, aluno.getCpf());
        ps.setString(3, aluno.getRg());
        ps.setString(4, aluno.getInstituicao());
        ps.setString(5, aluno.getObservacao());
        ps.setString(6, aluno.getTransporte());
        ps.setString(7, String.valueOf(aluno.getEndereco().getRua()));
        ps.setString(8, String.valueOf(aluno.getEndereco().getBairro()));
        ps.setString(9, String.valueOf(aluno.getEndereco().getCidade()));
        ps.setString(10, String.valueOf(aluno.getEndereco().getEstado()));
        ps.setString(11, String.valueOf(aluno.getEndereco().getCep()));
        ps.setString(12, String.valueOf(aluno.getContato().getTelefone()));
        ps.setString(13, String.valueOf(aluno.getContato().getEmail()));
        ps.execute();
    }

    public static int quantidade(String filtro) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT COUNT(1) FROM ALUNO WHERE NOME LIKE ?";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public static ObservableList<Aluno> listar(String filtro, int quantidade, int pagina) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM ALUNO WHERE NOME LIKE ? "
                + "ORDER BY NOME LIMIT ?,?";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ps.setInt(2, pagina * quantidade);
        ps.setInt(3, quantidade);
        ResultSet rs = ps.executeQuery();

        ObservableList listaClientes = FXCollections.observableArrayList();
        while (rs.next()) {
            Aluno cliente = new Aluno();
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf(rs.getString("CPF"));
            listaClientes.add(cliente);
        }

        return listaClientes;
    }

    public static Aluno recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM ALUNO WHERE CODIGO=?";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Aluno cliente = new Aluno();
        if (rs.next()) {
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf(rs.getString("CPF"));
        }

        return cliente;
    }
}
