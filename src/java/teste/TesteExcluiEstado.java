/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.Conexao;
import controle.EstadoDB;
import java.sql.Connection;

/**
 *
 * @author 5257
 */
public class TesteExcluiEstado {
    public static void main(String[] args) {
        String sigla = "BA";
        Connection conexao = Conexao.getConexao();
        boolean excluiu = EstadoDB.SetExcluiEstado(sigla, conexao);
        if(excluiu){
            System.out.println("Estado excluído!");
        }
        else{
            System.out.println("Erro ao excluir estado!");
        }
        Conexao.setFechaConexao(conexao);
    }
}
