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
public class ServidorUDPBroadcast {
    private DatagramSocket serverSocket;
    
    public ServidorUDPBroadcast()throws SocketException{
        
        serverSocket = new DatagramSocket();

    }
    
    public void runServer(){
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        while(true){
            try{
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                InetAddress ipAddress = 
                        InetAddress.getByName("10.20.24.255");
                
                String mensagemRecebida = "Hugo...";
                
                String upperEnviada = mensagemRecebida.toUpperCase();
                sendData = upperEnviada.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData, sendData.length,ipAddress, 
                        9876);
                serverSocket.send(sendPacket);
                System.out.println("Enviei...dormindo");
                Thread.sleep(100);
            }catch(IOException e){
                e.printStackTrace();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }
    
    
}
