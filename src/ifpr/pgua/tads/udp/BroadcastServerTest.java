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
public class BroadcastServerTest {
    public static void main(String[] args) throws Exception{
        ServidorUDPBroadcast server = new ServidorUDPBroadcast();
        server.runServer();
    }
}
