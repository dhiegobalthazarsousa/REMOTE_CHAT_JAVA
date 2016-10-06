package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import view.servidor.FrameServidor;

public class Socket_Cliente implements Runnable {

    private int porta;
    private String ip;

    public Socket_Cliente(String ip, int porta) {
        this.porta = porta;
        this.ip = ip;
    }

    public void ligarServidorCliente(int porta) {
        try {
            ServerSocket servidor = new ServerSocket(porta);

            System.out.println("Porta " + porta + " aberta!");

            Socket cliente = servidor.accept();

            Scanner entrada = new Scanner(cliente.getInputStream());

            while (entrada.hasNextLine()) {
                System.out.println("O cliente digitou: " + entrada.nextLine());
            }

            entrada.close();
            servidor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Socket cliente = new Socket(ip, porta);

            System.out.println("O cliente se conectou ao servidor!");

            ligarServidorCliente(porta);

            Scanner teclado = new Scanner(System.in);

            PrintStream saida = new PrintStream(cliente.getOutputStream());

            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }

            saida.close();
            teclado.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Impossivel conectar-se");
        }

    }
}
