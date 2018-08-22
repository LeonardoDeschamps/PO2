/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.PessoaDB;
import controle.Conexao;
import java.sql.Connection;

/**
 *
 * @author 5257
 */
public class TesteExcluiPessoa {
    public static void main(String[] args) {
        int codigo = 3;
        Connection conexao = Conexao.getConexao();
        boolean excluiu = PessoaDB.SetExcluiPessoa(codigo, conexao);
        if(excluiu){
            System.out.println("Pessoa excluída!");
        }
        else{
            System.out.println("Erro ao excluir pessoa!");
        }
        Conexao.setFechaConexao(conexao);
    }
}
