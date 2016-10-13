package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import view.cliente.FrameCliente;

public class Socket_Cliente implements Runnable {

    private int porta;
    public static String ip;
    public static Socket cliente;

    public Socket_Cliente(String ip, int porta) {
        this.porta = porta;
        this.ip = ip;
        
    }
    
    @Override
    public void run() {
        try {
            cliente = new Socket(ip, porta);
            FrameCliente.campoConectados.append("Cliente" + " " + ip + " " + "conectado!");
    
            System.out.println("O cliente se conectou ao servidor!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Impossivel conectar-se");
        }

    }
}
