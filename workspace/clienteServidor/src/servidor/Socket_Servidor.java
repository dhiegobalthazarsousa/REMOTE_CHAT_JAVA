package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import view.servidor.FrameServidor;

public class Socket_Servidor implements Runnable {

    private int porta;
    private String ip;

    public Socket_Servidor(int porta, String ip) {
        this.porta = porta;
        this.ip = ip;
    }

    public void ligarCliente(int porta, String ip) {
        try {
            Socket cliente = new Socket(ip, porta);

            System.out.println("Cliente do Servidor ligado!");

            Scanner teclado = new Scanner(System.in);

            PrintStream saida = new PrintStream(cliente.getOutputStream());

            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }

            saida.close();
            teclado.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Impossivel ligar cliente do servidor");
        }
    }

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(porta);

            System.out.println("Porta " + porta + " aberta!");
            
            ligarCliente(porta, ip);

            Socket cliente = servidor.accept();

            System.out.println("Nova conex�o com o cliente " + cliente.getInetAddress().getHostAddress());

            Scanner entrada = new Scanner(cliente.getInputStream());

            while (entrada.hasNextLine()) {
                System.out.println("O cliente digitou: " + entrada.nextLine());
            }

            entrada.close();
            servidor.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Impossivel ligar o servidor! Burro!");
        }

    }
}
