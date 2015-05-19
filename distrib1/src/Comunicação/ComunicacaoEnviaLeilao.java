/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import Modelo.Conexao;
import Modelo.Livro;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoEnviaLeilao extends MinhaComunicacaoEnvio {

    private Livro livro;

    public ComunicacaoEnviaLeilao(Livro livro) throws Exception {
        conexao = Conexao.getInstancia();
        ConfiguraConexaoMulticast();
        this.livro = livro;
    }

    @Override
    public void run() {
        try {
            mensagem = "3#" + livro.getCodigo() + "#" + livro.getDescricao() + "#" + livro.getNome() + "#"
                    + livro.getPrecoInicial() + "#" + livro.getTempoTotalLeilao() + "#" + System.currentTimeMillis()
                    + "#" + livro.getIdPublicaDonoLivro() + "#" + livro.getIdRedeDonoLivro();
            EnviaMensagem();
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnviaLeilao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
