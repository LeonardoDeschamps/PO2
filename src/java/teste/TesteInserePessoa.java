/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.PessoaDB;
import controle.Conexao;
import java.sql.Connection;
import modelo.Pessoa;

/**
 *
 * @author 5257
 */
public class TesteInserePessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(3,"Manoel",23,"teste@email",1);
        Connection conexao = Conexao.getConexao();
        boolean inseriu =PessoaDB.SetInserePessoa(pessoa, conexao);
        if(inseriu){
            System.out.println("Pessoa inserida!");
        }
        else{
            System.out.println("Erro ao inserir pessoa!");
        }             
        Conexao.setFechaConexao(conexao);
    }
}
