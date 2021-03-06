/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import Modelo.Conexao;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Envio de hello para clientes
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ControleHelloServidor extends Thread {

    private Conexao conexao;
    DatagramSocket serverSocket;
    InetAddress address;
    
    /**
     * Thread de envio de hello para clientes a fim de manter o status online frente aos mesmos
     */
    public void run() {
        try {
            conexao = Conexao.getInstancia();
            serverSocket = new DatagramSocket();
            address = InetAddress.getByName(conexao.getINET_ADDR());
            JanelaConsole.escreveNaJanela("Envia Hello iniciada.");
        } catch (UnknownHostException | SocketException | InterruptedException ex) {
            Logger.getLogger(ControleHelloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (true) {
            try {
                String mensagem = "1#ola";
                Date now = new Date();
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String dh = formatter.format(now);
                JanelaConsole.escreveNaJanela(dh + " Mandou: " + mensagem);
                DatagramPacket msgPacket = new DatagramPacket(mensagem.getBytes(), mensagem.getBytes().length, address, conexao.getPORT());
                serverSocket.send(msgPacket);
                sleep(8000);
            } catch (InterruptedException | IOException ex) {
                Logger.getLogger(ControleHelloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
