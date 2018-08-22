/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.Conexao;
import controle.CidadeDB;
import java.sql.Connection;
import modelo.Cidade;

/**
 *
 * @author 5257
 */
public class TesteAlteraCidade {
    public static void main(String[] args) {
        Cidade cidade = new Cidade(3,"Brasília","PR");
        Connection conexao = Conexao.getConexao();
        boolean alterou = CidadeDB.SetAlteraCidade(cidade, conexao);
        if(alterou){
            System.out.println("Cidade alterada!");
        }
        else{
            System.out.println("Erro ao alterar cidade!");
        }
        Conexao.setFechaConexao(conexao);
    }
}
