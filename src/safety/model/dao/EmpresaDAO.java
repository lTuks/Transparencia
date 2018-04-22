package safety.model.dao;

import safety.model.bean.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmpresaDAO {

    public static void salvar(Empresa empresa) throws Exception {
        if (empresa.getCodigo() == 0) {
            inserir(empresa);
        } else {
            alterar(empresa);
        }
    }

    public static void inserir(Empresa empresa) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO EMPRESA (CODIGO, NOMEFANTASIA, RAZAO, CNPJ, INSCRICAO, MATRIZ, REPRESENTANTE, CONTATO ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, String.valueOf(empresa.getCodigo()));
        ps.setString(2, empresa.getNomeFantasia());
        ps.setString(3, empresa.getRazaoSocial());
        ps.setString(4, empresa.getCnpj());
        ps.setString(5, empresa.getInscricao());
        ps.setString(6, empresa.getMatriz());
        ps.setString(7, empresa.getRepresentante());
        ps.setString(8, String.valueOf(empresa.getContato()));
        ps.execute();
        c.confirmar();
    }

    public static void alterar(Empresa empresa) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE EMPRESA SET NOMEFANTASIA=?, RAZAO=?, CNPJ=?, INSCRICAO=?, MATRIZ=?, REPRESENTANTE=?, TELEFONE=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, empresa.getCodigo());
        ps.setString(2, empresa.getNomeFantasia());
        ps.setString(3, empresa.getRazaoSocial());
        ps.setString(4, empresa.getCnpj());
        ps.setString(5, empresa.getInscricao());
        ps.setString(6, empresa.getMatriz());
        ps.setString(7, empresa.getRepresentante());
        ps.setString(8, String.valueOf(empresa.getContato().getTelefone()));
        ps.execute();
        c.confirmar();
    }

    public static void excluir(Empresa fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM EMPRESA WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, fornecedor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    public static int quantidade(String filtro) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT COUNT(1) FROM EMPRESA WHERE NOME LIKE ?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public static ObservableList<Empresa> listar(String filtro, int quantidade, int pagina) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM EMPRESA WHERE NOME LIKE ? ORDER BY NOME LIMIT ?,?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ps.setInt(2, pagina * quantidade);
        ps.setInt(3, quantidade);
        ResultSet rs = ps.executeQuery();
        ObservableList listaFornecedors = FXCollections.observableArrayList();
        while (rs.next()) {
            Empresa empresa = new Empresa();
            empresa.setCodigo(rs.getInt("CODIGO"));
            empresa.setNomeFantasia(rs.getString("NOME"));
            empresa.setCnpj(rs.getString("CNPJ"));
            empresa.setRazaoSocial(rs.getString("RAZAO"));
            empresa.setInscricao(rs.getString("INSCRICAO"));
            empresa.setMatriz(rs.getString("MATRIZ"));
            empresa.setRepresentante(rs.getString("REPRESENTANTE"));
            listaFornecedors.add(empresa);
        }

        return listaFornecedors;
    }

    public static Empresa recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM EMPRESA WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Empresa fornecedor = new Empresa();
        if (rs.next()) {
            fornecedor.setCodigo(rs.getInt("CODIGO"));
            fornecedor.setNomeFantasia(rs.getString("NOME"));
            fornecedor.setCnpj(rs.getString("CNPJ"));
        }

        return fornecedor;
    }
}
