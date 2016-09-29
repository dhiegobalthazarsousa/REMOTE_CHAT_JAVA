package servidor;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import view.servidor.JFrameChat;

public class Socket_Servidor {

    public static void main(String[] args) throws IOException {
       
        
        ServerSocket servidor = new ServerSocket(4567);

        System.out.println("Porta " + (4567) + " aberta!");

        Socket cliente = servidor.accept();

        System.out.println("Nova conex�o com o cliente " + cliente.getInetAddress().getHostAddress());

        Scanner entrada = new Scanner(cliente.getInputStream());

        while (entrada.hasNextLine()) {
            System.out.println("O cliente digitou: " + entrada.nextLine());
        }

        entrada.close();
        servidor.close();
    }
}
