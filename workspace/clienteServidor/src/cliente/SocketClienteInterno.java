/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.net.Socket;

/**
 *
 * @author a1655086
 */
public class SocketClienteInterno implements Runnable{

    private int porta;
    public static String ip;
    public static Socket cliente;

    public SocketClienteInterno(String ip, int porta) {
        this.porta = porta;
        this.ip = ip;
        
    }
    
    @Override
    public void run() {
        try {
            cliente = new Socket(ip, porta);
    
            System.out.println("O cliente se conectou ao servidor!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Impossivel conectar-se");
        }

    }
    
}
