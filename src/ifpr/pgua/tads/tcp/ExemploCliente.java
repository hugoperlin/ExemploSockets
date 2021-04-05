package ifpr.pgua.tads.tcp;

import java.io.IOException;
import java.util.Observable;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class ExemploCliente {


    public static void main(String[] args) {




        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("Conectando...");
            ClienteTCP clienteTCP = new ClienteTCP("localhost",12000);
            System.out.println("Conectado!");
            System.out.println("Digite mensagens (sair para encerrar)");
            while (true){
                String msg = scan.nextLine();

                if(msg.equals("sair")){
                    break;
                }
                String resposta = clienteTCP.processa(msg);
                System.out.println("RESPOSTA->>"+resposta);

            }
            clienteTCP.processa("SAIR");
            clienteTCP.fecha();



        }catch (IOException e){
            System.out.println("Ops, algo errado!!!\n"+e.getMessage());
        }

    }
}
