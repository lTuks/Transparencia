package DAO;

import java.sql.PreparedStatement;

public class CriarTabelas {

    public static void chamar() {
        Alunos();
        Transportes();
        OrgFomentador();
        Usuario();
    }

    private static void Alunos() {

        try {
            Conexao c = new Conexao();
            String sql = "SELECT * FROM aluno";
            PreparedStatement ps = c.getConnection().prepareStatement(sql);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            try {
                Conexao c = new Conexao();
                String sql = "create table Aluno( "
                        + "	Cod_Aluno serial primary key,"
                        + "	Nome varchar(50),"
                        + "	Cpf char(15),"
                        + "	RG char(13),"
                        + "	Instituicao varchar(60),"
                        + "	Situacao varchar(10),"
                        + "	Observacao varchar(200),"
                        + "	Transporte varchar(40),"
                        + "	Rua varchar(40),"
                        + "	Bairro varchar(30),"
                        + "	Cidade varchar(30),"
                        + "	Estado varchar(25),"
                        + "	CEP char(11),"
                        + "	Telefone char(15),"
                        + "	Email varchar(60)"
                        + "	)";
                PreparedStatement ps = c.getConnection().prepareStatement(sql);
                ps.execute();
                ps.close();
            } catch (Exception ee) {
            }
        }
    }

    private static void Transportes() {

        try {
            Conexao c = new Conexao();
            String sql = "SELECT * FROM empresa";
            PreparedStatement ps = c.getConnection().prepareStatement(sql);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            try {
                Conexao c = new Conexao();
                String sql = "create table Empresa("
                        + "	Cod_Empresa serial primary key,"
                        + "	nomefantasia varchar(50),"
                        + "	razaosocial varchar(50),"
                        + "	CNPJ char(18),"
                        + "	Inscricao_Estadual char(13),"
                        + "	Matriz varchar(30),"
                        + "	Representante varchar(50),"
                        + "	Telefone char(14),"
                        + "	Valor char(10)"
                        + "	)";
                PreparedStatement ps = c.getConnection().prepareStatement(sql);
                ps.execute();
                ps.close();
            } catch (Exception ee) {
            }
        }
    }

    private static void OrgFomentador() {

        try {
            Conexao c = new Conexao();
            String sql = "SELECT * FROM OrgFomentador";
            PreparedStatement ps = c.getConnection().prepareStatement(sql);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            try {
                Conexao c = new Conexao();
                String sql = "create table OrgFomentador("
                        + "	Cod_OrgFomentador serial primary key,"
                        + "	nomefantasia varchar(50),"
                        + "	razaosocial varchar(50),"
                        + "	CNPJ char(18),"
                        + "	Inscricao_Estadual char(13),"
                        + "	Representante varchar(50),"
                        + "	Telefone char(14)"
                        + "	)";
                PreparedStatement ps = c.getConnection().prepareStatement(sql);
                ps.execute();
                ps.close();
            } catch (Exception ee) {
            }
        }
    }

    private static void Usuario() {

        try {
            Conexao c = new Conexao();
            String sql = "SELECT * FROM Usuario";
            PreparedStatement ps = c.getConnection().prepareStatement(sql);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            try {
                Conexao c = new Conexao();
                String sql = "create table Usuario("
                        + "	Nome varchar(50),"
                        + "	Login varchar(15),"
                        + "	Senha varchar(15),"
                        + "	Resposta varchar(30)"
                        + "	);"
                        + "INSERT INTO Usuario(Nome, Login, Senha, Resposta) "
                        + "VALUES ('Administrador', 'admin', 'admin', 'admin')";
                PreparedStatement ps = c.getConnection().prepareStatement(sql);
                ps.execute();
                ps.close();
            } catch (Exception ee) {
            }
        }
    }
}
