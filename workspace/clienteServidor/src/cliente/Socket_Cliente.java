package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import view.servidor.Chat;

public class Socket_Cliente {

    public void connectClient(int porta, String ip) throws IOException {

        Socket cliente = new Socket(ip, porta);

        System.out.println("O cliente se conectou ao servidor!");

        Scanner teclado = new Scanner(System.in);

        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

       saida.close();
       teclado.close();
    }
}
