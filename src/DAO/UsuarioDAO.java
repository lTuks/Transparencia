package DAO;

import Bean.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    public static void salvar(Usuario usuario) throws Exception {
        Conexao c = new Conexao();
        PreparedStatement ps = c.getConnection().prepareStatement("INSERT INTO Usuario (Nome, Login, Senha, Resposta) " +
		"VALUES (?, ?, ?, ?)");
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getLogin());
                ps.setString(3, usuario.getSenha());
                ps.setString(4, usuario.getResposta());
                ps.execute();

    }
    
    public static Usuario verificacaoUsuarioLogin(String login, String senha) throws Exception {
        Conexao c = new Conexao();
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE login = ? AND senha = ?";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ps.setObject(1, login);
        ps.setObject(2, senha);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
        }
        return usuario;
    }
     public static Usuario verificacaoRespostaSecreta(String login, String resposta) throws Exception {
        Conexao c = new Conexao();
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE usuario.login ~'^"+ login +"' AND resposta ~'^" + resposta +"';";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setResposta(rs.getString("resposta"));
        }
        return usuario;
    }
}
