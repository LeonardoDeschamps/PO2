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
public class TesteAlteraPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(3,"Manoel Ávila",50,"teste@email",2);
        Connection conexao = Conexao.getConexao();
        boolean alterou = PessoaDB.SetAlteraPessoa(pessoa, conexao);
        if(alterou){
            System.out.println("Pessoa alterada!");
        }
        else{
            System.out.println("Erro ao alterar pessoa!");
        }
        Conexao.setFechaConexao(conexao);
    }
}
