package servidor;

import cliente.SocketClienteInterno;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import view.cliente.FrameCliente;

public class Socket_Servidor implements Runnable {

    @Override
    public void run() {
        try {
            
            ServerSocket servidor = new ServerSocket(12345);

            FrameCliente.labelRespostaServidor.setText("Porta aberta!");

            System.out.println("Porta aberta!");
            
            

            Socket cliente = servidor.accept();

            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
            FrameCliente.campoConectados.append("Cliente" + " " + cliente.getInetAddress().getHostName() + " " + "conectado!");
            
            SocketClienteInterno sci = new SocketClienteInterno(cliente.getInetAddress().getHostName(), 12346);
            Thread t = new Thread(sci);
            t.start();

            Scanner entrada = new Scanner(cliente.getInputStream());

            while (entrada.hasNextLine()) {
                String mensagem = entrada.nextLine();
                if (!mensagem.equals("")) {
                    System.out.println("O cliente digitou: " + mensagem);
                    FrameCliente.textoRecebimento.append(cliente.getInetAddress().getHostAddress() + ": " + mensagem + "\n");
                }

            }

            entrada.close();
            servidor.close();

        } catch (Exception e) {
            e.printStackTrace();

            FrameCliente.labelRespostaServidor.setText("Deu ruim, burro!");
            System.out.println("Impossivel ligar o servidor! Burro!");
        }

    }
}
