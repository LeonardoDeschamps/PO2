/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.Conexao;
import controle.CidadeDB;
import java.sql.Connection;

/**
 *
 * @author 5257
 */
public class TesteExcluiCidade {
    public static void main(String[] args) {
        int codigo = 3;
        Connection conexao = Conexao.getConexao();
        boolean excluiu = CidadeDB.SetExcluiCidade(codigo, conexao);
        if(excluiu){
            System.out.println("Cidade excluída!");
        }
        else{
            System.out.println("Erro ao excluir cidade!");
        }
        Conexao.setFechaConexao(conexao);
    }
}
