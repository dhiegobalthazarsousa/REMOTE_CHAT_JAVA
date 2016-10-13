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
    private String ip;

    public Socket_Cliente(String ip, int porta) {
        this.porta = porta;
        this.ip = ip;
    }
    
    @Override
    public void run() {
        try {
            Socket cliente = new Socket(ip, porta);

            System.out.println("O cliente se conectou ao servidor!");

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
