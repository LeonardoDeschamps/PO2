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
import modelo.Estado;

/**
 *
 * @author 5257
 */
public class EstadoDB {
    
    public static ArrayList getEstados(Connection conexao){
        ArrayList lista = new ArrayList();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from estado");
            while(rs.next()){
                String sigla = rs.getString("est_sigla");
                String nome = rs.getString("nome");
                Estado estado = new Estado(sigla, nome);
                lista.add(estado);
            }
        }
        catch(SQLException erro){
            System.out.println("Erro de SQL: " + erro.getMessage());
        } 
        return lista;
    }
    
    
    public static boolean SetInsereEstado(Estado estado, Connection conexao){
        boolean inseriu = false;
        try{
            PreparedStatement pst = conexao.prepareStatement("insert into estado (est_sigla,nome) values (?,?)");
            pst.setString(1, estado.getEst_sigla());
            pst.setString(2, estado.getNome());
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
    
    public static boolean SetAlteraEstado(Estado estado, Connection conexao){
        boolean alterou = false;
        try{
            PreparedStatement pst = conexao.prepareStatement("update estado set nome = ? where est_sigla = ?");
            pst.setString(1, estado.getNome());
            pst.setString(2, estado.getEst_sigla());
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
    
    public static boolean SetExcluiEstado(String sigla, Connection conexao){
        boolean excluiu = false;
        try{
            PreparedStatement pst = conexao.prepareStatement("delete from estado where est_sigla = ?");
            pst.setString(1, sigla);
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
