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
public class BroadcastClientTest {
    public static void main(String[] args) throws Exception{
        ClienteUDPBrodcast clienteUDP = new ClienteUDPBrodcast();
        clienteUDP.runClient();
    }
}
