/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import GUI.JanelaCriaLeilao;
import GUI.JanelaLeilaoAcontecendo;
import GUI.JanelaLeilaoIniciado;
import Modelo.Conexao;
import Modelo.Lance;
import Modelo.Livro;
import Modelo.Usuario;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoRecebe extends Thread {

    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private Conexao conexao;
    private Usuario usuarioLocal;
    private String[] mensagemQuebrada;
    private String mensagem;
    private int participantesTempoAdicional;

    InetAddress address;
    MulticastSocket clientSocket;

    @Override
    public void run() {
        try {
            JanelaConsole.escreveNaJanela("Thread de recepção iniciada.");

            participantesTempoAdicional = 0;
            //Obtem o usuário local
            usuarioLocal = Usuario.getInstancia();
            conexao = Conexao.getInstancia();
            ConfiguraConexao();
            while (conexao.isServidorOnline()) {
                //Obtem a conexão
                conexao = Conexao.getInstancia();
                byte[] buf = new byte[256];
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                clientSocket.receive(msgPacket);
                mensagem = new String(buf);
                mensagem = mensagem.trim();
                mensagemQuebrada = mensagem.split("#");
                DirecionaMensagem();
            }
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoRecebe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RecebeParticipantes() throws Exception {
        Usuario usuario = new Usuario(Integer.parseInt(mensagemQuebrada[2]), mensagemQuebrada[1], null, null, mensagemQuebrada[3]);
        boolean naoAchou = true;
        for (Usuario us : usuarios) {
            if (us.getIdPublica().equalsIgnoreCase(usuario.getIdPublica()) && us.getIdRede() == usuario.getIdRede()) {
                naoAchou = false;
            }
        }
        if (naoAchou) {
            usuarios.add(usuario);
            conexao.setQuantidadeUsuarios(conexao.getQuantidadeUsuarios() + 1);
            Conexao.setInstancia(conexao);
            JanelaCriaLeilao.atualizar(usuarios);
            if (usuarioLocal.getPapel().equalsIgnoreCase("servidor") && ((!(usuario.getIdPublica().equals(usuarioLocal.getIdPublica()))) && (usuario.getIdRede() > usuarioLocal.getIdRede()))) {
                usuarioLocal.setPapel("cliente");
                Usuario.setInstancia(usuarioLocal);
            }
        }
        if (usuarios.size() >= 2) {
            JanelaConsole.escreveNaJanela("Aguarde mais alguns segundos");
            JanelaConsole.escreveNaJanela("enquanto identificamos se pode haver mais conexões.");
            conexao.setStatusLeilao("tempoAdicional");
        }
    }

    public void RecebeParticipantesTempoAdicional() throws Exception {
        Usuario usuario = new Usuario(Integer.parseInt(mensagemQuebrada[2]), mensagemQuebrada[1], null, null, mensagemQuebrada[3]);
        boolean naoAchou = true;
        for (Usuario us : usuarios) {
            if (us.getIdPublica().equalsIgnoreCase(usuario.getIdPublica()) && us.getIdRede() == usuario.getIdRede()) {
                naoAchou = false;
            }
        }
        if (naoAchou) {
            usuarios.add(usuario);
            conexao.setQuantidadeUsuarios(conexao.getQuantidadeUsuarios() + 1);
            Conexao.setInstancia(conexao);
            JanelaCriaLeilao.atualizar(usuarios);
            if (usuarioLocal.getPapel().equalsIgnoreCase("servidor") && ((!(usuario.getIdPublica().equals(usuarioLocal.getIdPublica()))) && (usuario.getIdRede() > usuarioLocal.getIdRede()))) {
                usuarioLocal.setPapel("cliente");
                Usuario.setInstancia(usuarioLocal);
            }
        }
        participantesTempoAdicional++;
        sleep(1000);
        if (participantesTempoAdicional > 9) {
            conexao.setStatusLeilao("andamento");
            participantesTempoAdicional = 0;
            if (usuarioLocal.getPapel().equalsIgnoreCase("servidor")) {
                JanelaConsole.escreveNaJanela("Característica já definida: SERVIDOR");
                ControleHelloServidor hello = new ControleHelloServidor();
                hello.start();
                ControleLeilaoServidor leilao = new ControleLeilaoServidor();
                leilao.start();
            } else {
                JanelaConsole.escreveNaJanela("Característica já definida: CLIENTE");
                ControleEscutaServidor helloescuta = new ControleEscutaServidor();
                helloescuta.start();
            }
            Conexao.setInstancia(conexao);
            JanelaConsole.escreveNaJanela("Aguardando inicio de Leilão.");
            JanelaCriaLeilao.mostraBotao(true);
        }
    }

    //Configura a conexao
    public void ConfiguraConexao() throws Exception {
        address = InetAddress.getByName(conexao.getINET_ADDR());
        clientSocket = new MulticastSocket(conexao.getPORT());
        clientSocket.joinGroup(address);
    }

    //direcionar mensagem para um método ou thread
    public void DirecionaMensagem() throws Exception {
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dh = formatter.format(now);
        int tipoMensagem = Integer.parseInt(mensagemQuebrada[0]);
        switch (tipoMensagem) {
            //Para Hello do Servidor
            case 1:
                if (!(usuarioLocal.getPapel().equalsIgnoreCase("servidor"))) {
                    JanelaConsole.escreveNaJanela(dh + " Recebeu: " + mensagem);
                    HelloServer();
                }
                break;

            //Novo livro para leilão
            case 2:
                if (usuarioLocal.getPapel().equalsIgnoreCase("servidor")) {
                    JanelaConsole.escreveNaJanela(dh + " Recebeu: " + mensagem);
                    AdicionaLivroEstante();
                }
                break;

            //Inicio de novo Leilão
            case 3:
                JanelaConsole.escreveNaJanela(dh + " Recebeu: " + mensagem);
                InicioDoLeilao();
                break;

            //...
            case 4:
                JanelaConsole.escreveNaJanela(dh + " Recebeu: " + mensagem);
                LanceDeLeilao();
                break;

            //...
            case 11:

                break;

            //finalização remota de leilão
            case 15:
                if (usuarioLocal.getPapel().equalsIgnoreCase("servidor")) {
                    JanelaConsole.escreveNaJanela(dh + " Recebeu: " + mensagem);
                    FinalizarLeilaoAgora();
                }
                break;

            //escuta o multicast inicial
            case 77:
                JanelaConsole.escreveNaJanela(dh + " Recebeu: " + mensagem);
                if (conexao.getStatusLeilao().equalsIgnoreCase("aguardando")) {
                    RecebeParticipantes();
                }
                if (conexao.getStatusLeilao().equalsIgnoreCase("tempoAdicional")) {
                    RecebeParticipantesTempoAdicional();
                }
                break;

            default:
                JanelaConsole.escreveNaJanela("A última mensagem recebida é desconhecida.");
        }
    }

    //Salva os participantes do leilão
    public void MantemParticipantes() {

    }

    public void EscutaLeilao() throws Exception {

    }

    //Escuta Hello Servidor
    public void HelloServer() throws Exception {
        conexao.setUltimoHelloServer(System.currentTimeMillis());
        Conexao.setInstancia(conexao);
    }

    //Adiciona o livro na fila para que sejam leiloados
    public void AdicionaLivroEstante() throws Exception {
        conexao = Conexao.getInstancia();
        ArrayList<Livro> estante = conexao.getEstante();
        Livro livro = new Livro();
        livro.setCodigo(mensagemQuebrada[1]);
        livro.setDescricao(mensagemQuebrada[2]);
        livro.setNome(mensagemQuebrada[3]);
        livro.setPrecoInicial(Double.parseDouble(mensagemQuebrada[4]));
        livro.setTempoTotalLeilao(Long.parseLong(mensagemQuebrada[5]));
        livro.setIdPublicaDonoLivro(mensagemQuebrada[6]);
        livro.setIdRedeDonoLivro(Integer.parseInt(mensagemQuebrada[7]));
        estante.add(livro);
        conexao.setEstante(estante);
    }

    public void InicioDoLeilao() {
        Livro livro = new Livro();
        livro.setCodigo(mensagemQuebrada[1]);
        livro.setDescricao(mensagemQuebrada[2]);
        livro.setNome(mensagemQuebrada[3]);
        livro.setPrecoInicial(Double.parseDouble(mensagemQuebrada[4]));
        livro.setTempoTotalLeilao(Long.parseLong(mensagemQuebrada[5]));
        livro.setTempoNoInicio(Long.parseLong(mensagemQuebrada[6]));
        livro.setIdPublicaDonoLivro(mensagemQuebrada[7]);
        livro.setIdRedeDonoLivro(Integer.parseInt(mensagemQuebrada[8]));
        conexao = Conexao.getInstancia();
        conexao.setLeilaoAtual(livro);
        conexao.setStatusLeilao("leiloando");
        JanelaLeilaoIniciado jli = new JanelaLeilaoIniciado(livro);
        jli.setVisible(true);
    }

    public void LanceDeLeilao() {
        conexao = Conexao.getInstancia();
        usuarioLocal = Usuario.getInstancia();
        if (conexao.getLeilaoAtual().getCodigo().equalsIgnoreCase(mensagemQuebrada[1])) {
            Lance lance = new Lance(mensagemQuebrada[3], Integer.parseInt(mensagemQuebrada[4]), System.currentTimeMillis());
            lance.setValorOferecidoString(mensagemQuebrada[2]);
            if (conexao.getLeilaoAtual().getMaiorLance() == null) {
                if (usuarioLocal.getPapel().equalsIgnoreCase("servidor")) {
                    conexao.getLeilaoAtual().setMaiorLance(lance);
                }
                JanelaLeilaoAcontecendo jla = new JanelaLeilaoAcontecendo(lance);
                jla.setVisible(true);
            } else {
                if (conexao.getLeilaoAtual().getMaiorLance().getValorOferecido() < lance.getValorOferecido()) {
                    if (usuarioLocal.getPapel().equalsIgnoreCase("servidor")) {
                        conexao.getLeilaoAtual().setMaiorLance(lance);
                    }
                    JanelaLeilaoAcontecendo jla = new JanelaLeilaoAcontecendo(lance);
                    jla.setVisible(true);
                }
            }
        }
    }

    public void FinalizarLeilaoAgora() {
        usuarioLocal = Usuario.getInstancia();
        if ((usuarioLocal.getIdPublica().equalsIgnoreCase(mensagemQuebrada[1]))
                && usuarioLocal.getIdRede() == Integer.valueOf(mensagemQuebrada[2])) {
            conexao = Conexao.getInstancia();
            conexao.setStatusLeilao("finalizando");
        }
    }

}
