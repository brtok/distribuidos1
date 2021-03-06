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
 * Classe responsável pelo envio da mensagem de finalização do leilão
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ComunicacaoEnviaFinalLeilao extends MinhaComunicacaoEnvio {

    private Livro livro;

    public ComunicacaoEnviaFinalLeilao(Livro livro) throws Exception {
        conexao = Conexao.getInstancia();
        ConfiguraConexaoMulticast();
        this.livro = livro;
    }

    /**
     * Monta a mensagem de finalização de leilão e aciona o método de envio
     */
    @Override
    public void run() {
        try {
            if (livro.getMaiorLance() == null) {
                setMensagem("11#" + livro.getCodigo() + "#" + livro.getDescricao() + "#" + livro.getNome()
                        + "#" + livro.getPrecoInicial() + "#" + livro.getIdPublicaDonoLivro() + "#"
                        + livro.getIdRedeDonoLivro() + "#-1#-1#ninguem");
            } else {
                setMensagem("11#" + livro.getCodigo() + "#" + livro.getDescricao() + "#" + livro.getNome()
                        + "#" + livro.getPrecoInicial() + "#" + livro.getIdPublicaDonoLivro() + "#"
                        + livro.getIdRedeDonoLivro() + "#" + livro.getMaiorLance().getValorOferecidoString() + "#"
                        + livro.getMaiorLance().getIdRedeQuemOfereceu() + "#"
                        + livro.getMaiorLance().getIdPublicaQuemOfereceu());
            }
            EnviaMensagem();
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnviaFinalLeilao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
