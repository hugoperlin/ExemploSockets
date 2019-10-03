package ifpr.pgua.tads.tcp;

import java.io.IOException;
import java.util.Scanner;

public class ExemploCliente {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            ClienteTCP clienteTCP = new ClienteTCP("localhost",12000);

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

        }

    }
}
