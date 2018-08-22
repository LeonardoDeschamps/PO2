/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.Conexao;
import controle.EstadoDB;
import java.sql.Connection;
import modelo.Estado;

/**
 *
 * @author 5257
 */
public class TesteAlteraEstado {    
    public static void main(String[] args) {
        Estado estado = new Estado("BA", "Brasília");
        Connection conexao = Conexao.getConexao();
        boolean alterou = EstadoDB.SetAlteraEstado(estado, conexao);
        if(alterou){
            System.out.println("Estado alterado!");
        }
        else{
            System.out.println("Erro ao alterar estado!");
        }
        Conexao.setFechaConexao(conexao);
    }
}
