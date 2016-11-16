package view.cliente;

import static cliente.SocketClienteInterno.cliente;
import java.io.PrintStream;

/**
 *
 * @author a1655086
 */
public class BufferSaida implements Runnable{

    @Override
    public void run() {
        try{
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            FrameCliente.textoRecebimento.append("Eu digitei: " + FrameCliente.textEnvio.getText());
            saida.println(FrameCliente.textEnvio.getText());
            FrameCliente.textEnvio.setText("");
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
}
