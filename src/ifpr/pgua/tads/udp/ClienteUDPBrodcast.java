package ifpr.pgua.tads.udp;

// Código do cliente
import java.io.EOFException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class ClienteUDPBrodcast{
  
   private DatagramSocket udpClient; 
   
   public ClienteUDPBrodcast() throws UnknownHostException,SocketException{
       
      udpClient = new DatagramSocket(9876);
      udpClient.setBroadcast(true);
      
   } 

   public void runClient(){
        while(true){
        try{ // conecta ao servidor, cria os objetos de fluxos e processa as mensagens
         byte[] receiveData = new byte[1024];
         
         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         udpClient.receive(receivePacket);
         String resposta = new String(receivePacket.getData());
         
         System.out.println(receivePacket.getAddress().toString()
                            +"->"+resposta);

      } 
      catch ( EOFException eofException ){
         eofException.printStackTrace();
      } 
      catch ( IOException ioException ){
         ioException.printStackTrace();
      }
        }
   } 
 
} // end class Client

/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
