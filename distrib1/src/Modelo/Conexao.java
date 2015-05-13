/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class Conexao {
    
    private String statusLeilao;
    private String INET_ADDR;
    private int PORT;
    private int quantidadeUsuarios;
    private long ultimoHelloServer;
    private ArrayList<Livro> balcao = new ArrayList<>();
    private ArrayList<Livro> estante = new ArrayList<>();
    
    private static Conexao instancia;    
 
    public String getINET_ADDR() {
        return INET_ADDR;
    }

    public void setINET_ADDR(String INET_ADDR) {
        this.INET_ADDR = INET_ADDR;
    }

    public int getPORT() {
        return PORT;
    }

    public void setPORT(int PORT) {
        this.PORT = PORT;
    }

    public static Conexao getInstancia() {
        if (instancia == null)
        {
            instancia = new Conexao();
        }
        return instancia;
    }

    public static void setInstancia(Conexao instancia) {
        Conexao.instancia = instancia;
    }

    public String getStatusLeilao() {
        return statusLeilao;
    }

    public void setStatusLeilao(String statusLeilao) {
        this.statusLeilao = statusLeilao;
    }

    public int getQuantidadeUsuarios() {
        return quantidadeUsuarios;
    }

    public void setQuantidadeUsuarios(int quantidadeUsuarios) {
        this.quantidadeUsuarios = quantidadeUsuarios;
    }   

    public ArrayList<Livro> getBalcao() {
        return balcao;
    }

    public void setBalcao(ArrayList<Livro> balcao) {
        this.balcao = balcao;
    }  

    public long getUltimoHelloServer() {
        return ultimoHelloServer;
    }

    public void setUltimoHelloServer(long ultimoHelloServer) {
        this.ultimoHelloServer = ultimoHelloServer;
    }

    public ArrayList<Livro> getEstante() {
        return estante;
    }

    public void setEstante(ArrayList<Livro> estante) {
        this.estante = estante;
    }
    
    
    
}
