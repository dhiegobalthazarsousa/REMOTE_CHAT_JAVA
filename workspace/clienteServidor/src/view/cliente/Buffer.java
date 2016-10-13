/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cliente;

import static cliente.Socket_Cliente.cliente;
import java.io.PrintStream;
import static view.cliente.FrameCliente.textEnvio;

/**
 *
 * @author a1655086
 */
public class Buffer implements Runnable{

    @Override
    public void run() {
        try{
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            saida.println(FrameCliente.textEnvio.getText());
            FrameCliente.textEnvio.setText("");
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
}
