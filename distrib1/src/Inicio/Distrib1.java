package Inicio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Chaves.ControladoraChaves;
import GUI.JanelaConsole;
import GUI.JanelaMinhaIDPublica;
import Modelo.Conexao;
import Modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe inicial do programa
 *
 * @author Bruno Tokarski e Rafael Vidal
 */
public class Distrib1 {

    /**
     * Inicia a execução do programa
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Distrib1.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Cria e instancia o usuário
        Usuario usuario = Usuario.getInstancia();

        usuario.setIdRede((int) (Math.random() * 100));
        usuario.setPapel("servidor");

        //Cria e instancia a conexão
        Conexao conexao = Conexao.getInstancia();
        conexao.setINET_ADDR("228.5.6.7");
        conexao.setPORT(8885);
        conexao.setStatusLeilao("aguardando");
        conexao.setServidorOnline(true);

        //Obtem o par de chaves para o usuário
        ControladoraChaves cc = new ControladoraChaves();
        cc.GeraChaves();

        Usuario.setInstancia(usuario);
        Conexao.setInstancia(conexao);
        
        JanelaConsole console = JanelaConsole.getInstancia();
        console.setVisible(true);
        console.repaint();

        JanelaMinhaIDPublica jid = new JanelaMinhaIDPublica();
        jid.setVisible(true);
        jid.repaint();
    }

}
