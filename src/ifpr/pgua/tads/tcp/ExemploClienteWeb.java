package ifpr.pgua.tads.tcp;

import java.io.IOException;
import java.util.Scanner;

public class ExemploClienteWeb {


    public static void main(String[] args) {
        try{
            ClienteWeb clienteWeb = new ClienteWeb("info.cern.ch",80);

            String resposta = clienteWeb.processa();
            System.out.println(resposta);
            clienteWeb.fecha();



        }catch (IOException e){

        }

    }
}
