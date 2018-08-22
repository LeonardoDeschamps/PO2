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
public class TesteInsereCidade {
    public static void main(String[] args) {
        Cidade cidade = new Cidade(3,"Laurentino","SC");
        Connection conexao = Conexao.getConexao();
        boolean inseriu =CidadeDB.SetInsereCidade(cidade, conexao);
        if(inseriu){
            System.out.println("Cidade inserida!");
        }
        else{
            System.out.println("Erro ao inserir cidade!");
        }             
        Conexao.setFechaConexao(conexao);
    }
}
