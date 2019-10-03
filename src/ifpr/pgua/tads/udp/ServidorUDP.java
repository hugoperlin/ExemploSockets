/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.pgua.tads.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author haperlin
 */
public class ServidorUDP {
    private DatagramSocket serverSocket;
    
    public ServidorUDP()throws SocketException{
        
        serverSocket = new DatagramSocket(9876);

    }
    
    public void runServer(){
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            try{
                DatagramPacket receivePacket = 
                        new DatagramPacket(receiveData, 
                                receiveData.length);
                serverSocket.receive(receivePacket);
                InetAddress ipAddress = receivePacket.getAddress();
                int porta = receivePacket.getPort();
                String mensagemRecebida = new String(
                                   receivePacket.getData());
                System.out.println("Recebido de "+
                            ipAddress.toString()+":"+
                        mensagemRecebida);
                
                String upperEnviada = mensagemRecebida.toUpperCase();
                sendData = upperEnviada.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(
                                          sendData, sendData.length,
                                          ipAddress, porta);
                serverSocket.send(sendPacket);
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }
    }
    
    
}
