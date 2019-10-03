/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.pgua.tads.udp;

/**
 *
 * @author haperlin
 */
public class ClientTest {
    public static void main(String[] args) throws Exception{
        ClienteUDP clienteUDP = new ClienteUDP("127.0.0.1",9876);
        clienteUDP.runClient("Mensagem teste");
    }
}
