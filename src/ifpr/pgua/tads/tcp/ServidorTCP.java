package ifpr.pgua.tads.tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    private ServerSocket servidor;
    private Socket cliente;
    private String HOST;
    private int PORTA;

    private BufferedReader entrada;
    private BufferedWriter saida;


    public ServidorTCP(String HOST,int PORTA)throws IOException {
        servidor = new ServerSocket(PORTA);
    }

    public void escuta() throws IOException {
        System.out.println("Aguardando conexão...");
        cliente = servidor.accept();
        System.out.println("Conectado..."+cliente.getInetAddress()+":"+cliente.getPort());

        abreFluxos();

    }

    private void abreFluxos() throws IOException{
        entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        saida = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
    }

    public void processa(){

        try{
            while(true){
                String msgEntrada = entrada.readLine();

                System.out.println("RECEBIDO --> "+msgEntrada);
                if(msgEntrada.toLowerCase().equals("sair")){
                    break;
                }
                msgEntrada = msgEntrada.toUpperCase();
                saida.write(msgEntrada+"\n");
                saida.flush();

            }
        }catch (IOException e){

        }

    }

    public void fecha() throws IOException{
        entrada.close();
        saida.close();
        cliente.close();
    }






}
