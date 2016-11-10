package cliente;

import java.net.Socket;

public class SocketClienteExterno implements Runnable {

    private int porta;
    public static String ip;
    public static Socket cliente;

    public SocketClienteExterno(String ip, int porta) {
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
