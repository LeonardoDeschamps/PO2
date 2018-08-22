/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Cidade;

/**
 *
 * @author 5257
 */
public class CidadeDB {
    public static ArrayList getCidades(Connection conexao){
        ArrayList lista = new ArrayList();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from cidade");
            while(rs.next()){
                int codigo = rs.getInt("cid_codigo");
                String sigla = rs.getString("est_sigla");
                String nome = rs.getString("nome");
                Cidade cidade = new Cidade(codigo, nome, sigla);
                lista.add(cidade);
            }
        }
        catch(SQLException erro){
            System.out.println("Erro de SQL: " + erro.getMessage());
        } 
        return lista;
    }
    
    
    public static boolean SetInsereCidade(Cidade cidade, Connection conexao){
        boolean inseriu = false;
        try{
            PreparedStatement pst = conexao.prepareStatement("insert into cidade (cid_codigo, est_sigla,nome) values (?,?,?)");
            pst.setInt(1, cidade.getCid_codigo());
            pst.setString(2, cidade.getEst_sigla());
            pst.setString(3, cidade.getNome());
            int valor = pst.executeUpdate();
            if(valor == 1){
                inseriu = true;
            }
        }
        catch(SQLException erro){
            System.out.println("Erro de inserção: " + erro.getMessage());
        }
        return inseriu;
    }
    
    public static boolean SetAlteraCidade(Cidade cidade, Connection conexao){
        boolean alterou = false;
        try{
            PreparedStatement pst = conexao.prepareStatement("update cidade set nome = ?, est_sigla = ? where cid_codigo = ?");
            pst.setString(1, cidade.getNome());
            pst.setString(2, cidade.getEst_sigla());
            pst.setInt(3, cidade.getCid_codigo());
            int valor = pst.executeUpdate();
            if(valor == 1){
                alterou = true;
            }
        }
        catch(SQLException erro){
            System.out.println("Erro ao alterar: " + erro.getMessage());
        }
        return alterou;
    }
    
    public static boolean SetExcluiCidade(int codigo, Connection conexao){
        boolean excluiu = false;
        try{
            PreparedStatement pst = conexao.prepareStatement("delete from cidade where cid_codigo = ?");
            pst.setInt(1, codigo);
            int valor = pst.executeUpdate();
            if(valor == 1){
                excluiu = true;
            }
        }
        catch(SQLException erro){
            System.out.println("Erro ao excluir: " + erro.getMessage());
        }
        return excluiu;
    }
}
