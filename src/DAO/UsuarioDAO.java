package DAO;

import Bean.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
        public static void salvar(Usuario usuario) throws Exception {
        if (usuario.getCodigo() == 0) {
            inserir(usuario);
        }
    }

    public static void inserir(Usuario usuario) throws Exception {
        Conexao c = new Conexao();
        PreparedStatement ps = c.getConnection().prepareStatement("INSERT INTO Usuario (Nome, Login, Senha) " +
		"VALUES (?, ?, ?)");
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getLogin());
                ps.setString(3, usuario.getSenha()); 
                ps.execute();

    }
    
    public Usuario verificacaoUsuarioLogin(String login, String senha, String Nome) throws Exception {
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
    
    public List<Usuario> consultarPessoa()  throws Exception {
        Conexao c = new Conexao();
        List<Usuario> lista = new ArrayList();
        String sql = "SELECT * FROM usuario";
        PreparedStatement ps = c.getConnection().prepareStatement(sql);        
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Usuario pessoa = new Usuario();
            pessoa.setNome(rs.getString("nome"));
            pessoa.setLogin(rs.getString("login"));
            pessoa.setSenha(rs.getString("senha"));
            lista.add(pessoa);
        }
        return lista;
    }
}
