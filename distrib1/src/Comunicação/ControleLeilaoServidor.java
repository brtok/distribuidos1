/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import Modelo.Conexao;
import Modelo.Livro;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controladora de leilões
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ControleLeilaoServidor extends Thread {

    private Usuario usuario;
    private Conexao conexao;
    private Livro livro;

    /**
     * Thread responsável por administrar o leilão
     */
    @Override
    public void run() {
        try {
            JanelaConsole.escreveNaJanela("Thread Controle de Leilão Iniciada.");
        } catch (InterruptedException ex) {
            Logger.getLogger(ControleLeilaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao = Conexao.getInstancia();
        while (conexao.isServidorOnline()) {
            try {
                ArrayList<Livro> estante = conexao.getEstante();
                if ((!(estante.isEmpty()))
                        && (conexao.getStatusLeilao().equalsIgnoreCase("andamento"))) {
                    livro = estante.get(0);
                    ComunicacaoEnviaLeilao leiloa = new ComunicacaoEnviaLeilao(livro);
                    leiloa.start();
                    conexao.setStatusLeilao("leiloando");
                    estante.remove(0);
                    conexao.setEstante(estante);
                }
                while (conexao.getStatusLeilao().equalsIgnoreCase("leiloando")) {
                    sleep(1000);
                    Long horarioTerminoLeilao = conexao.getLeilaoAtual().getTempoNoInicio() + conexao.getLeilaoAtual().getTempoTotalLeilao();
                    Long horarioAgora = System.currentTimeMillis();
                    if (horarioAgora >= horarioTerminoLeilao) {
                        conexao.setStatusLeilao("finalizando");
                    }
                }
                if (conexao.getStatusLeilao().equalsIgnoreCase("finalizando")) {
                    ComunicacaoEnviaFinalLeilao finaliza = new ComunicacaoEnviaFinalLeilao(conexao.getLeilaoAtual());
                    finaliza.start();
                    conexao.setStatusLeilao("andamento");
                }
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControleLeilaoServidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControleLeilaoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
