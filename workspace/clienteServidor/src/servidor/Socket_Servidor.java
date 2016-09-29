package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import view.servidor.JFrameChat;

public class Socket_Servidor {

    public void onServer(int porta) throws IOException{

        ServerSocket servidor = new ServerSocket(porta);

        System.out.println("Porta " + (porta) + " aberta!");

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
