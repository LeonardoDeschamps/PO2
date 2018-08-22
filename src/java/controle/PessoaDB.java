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
import modelo.Pessoa;

/**
 *
 * @author 5257
 */
public class PessoaDB {
    public static ArrayList getPessoas(Connection conexao){
        ArrayList lista = new ArrayList();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from pessoa");
            while(rs.next()){                
                int codigo = rs.getInt("pes_codigo");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String email = rs.getString("email");
                int cidade = rs.getInt("cid_codigo");                                
                Pessoa pessoa = new Pessoa(codigo, nome, idade, email, codigo);
                lista.add(pessoa);
            }
        }
        catch(SQLException erro){
            System.out.println("Erro de SQL: " + erro.getMessage());
        } 
        return lista;
    }
    
    
    public static boolean SetInserePessoa(Pessoa pessoa, Connection conexao){
        boolean inseriu = false;
        try{
            PreparedStatement pst = conexao.prepareStatement("insert into pessoa (pes_codigo, nome, idade, email, cid_codigo) values (?,?,?,?,?)");
            pst.setInt(1, pessoa.getPes_codigo());
            pst.setString(2, pessoa.getNome());
            pst.setInt(3, pessoa.getIdade());
            pst.setString(4, pessoa.getEmail());
            pst.setInt(5, pessoa.getCid_codigo());
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
    
    public static boolean SetAlteraPessoa(Pessoa pessoa, Connection conexao){
        boolean alterou = false;
        try{
            PreparedStatement pst = conexao.prepareStatement("update pessoa set nome = ?, email = ?, idade = ?, cid_codigo = ? where pes_codigo = ?");
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEmail());
            pst.setInt(3, pessoa.getIdade());
            pst.setInt(4, pessoa.getCid_codigo());
            pst.setInt(5, pessoa.getPes_codigo());
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
    
    public static boolean SetExcluiPessoa(int codigo, Connection conexao){
        boolean excluiu = false;
        try{
            PreparedStatement pst = conexao.prepareStatement("delete from pessoa where pes_codigo = ?");
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
