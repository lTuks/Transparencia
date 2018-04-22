package safety.model.dao;

import safety.model.bean.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoDAO {

    public static void salvar(Aluno cliente) throws Exception {
        if (cliente.getCodigo() == 0) {
            inserir(cliente);
        } else {
            alterar(cliente);
        }
    }

    public static void inserir(Aluno cliente) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO ALUNO (CODIGO, NOME, CPF, RG, INSTITUICAO, OBSERVACAO, TRANSPORTE, ENDERECO, TELEFONE, CONTATO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, String.valueOf(cliente.getCodigo()));
        ps.setString(2, cliente.getNome());
        ps.setString(3, cliente.getCpf());
        ps.setString(4, cliente.getRg());
        ps.setString(5, cliente.getInstituicao());
        ps.setString(6, cliente.getObservacao());
        ps.setString(7, cliente.getTransporte());
        ps.setString(8, String.valueOf(cliente.getEndereco()));
        ps.setString(14, String.valueOf(cliente.getContato()));
        ps.execute();
        c.confirmar();
    }

    public static void alterar(Aluno cliente) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE ALUNO SET NOME=?, CPF=?, INSTITUICAO=?, TRANSPORTE=?, ENDERECO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getInstituicao());
        ps.setString(4, cliente.getTransporte());
        ps.setString(5, String.valueOf(cliente.getEndereco()));
        ps.setInt(6, cliente.getCodigo());
        ps.execute();
        c.confirmar();
    }

    public static void excluir(Aluno cliente) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM ALUNO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, cliente.getCodigo());
        ps.execute();
        c.confirmar();
    }

    public static int quantidade(String filtro) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT COUNT(1) FROM ALUNO WHERE NOME LIKE ?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public static ObservableList<Aluno> listar(String filtro, int quantidade, int pagina) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM ALUNO WHERE NOME LIKE ? ORDER BY NOME LIMIT ?,?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ps.setInt(2, pagina * quantidade);
        ps.setInt(3, quantidade);
        ResultSet rs = ps.executeQuery();

        ObservableList listaClientes = FXCollections.observableArrayList();
        while (rs.next()) {
            Aluno cliente = new Aluno();
            cliente.setCodigo(rs.getInt("CODIGO"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf(rs.getString("CPF"));
            listaClientes.add(cliente);
        }

        return listaClientes;
    }

    public static Aluno recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM ALUNO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Aluno cliente = new Aluno();
        if (rs.next()) {
            cliente.setCodigo(rs.getInt("CODIGO"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf(rs.getString("CPF"));
        }

        return cliente;
    }
}
