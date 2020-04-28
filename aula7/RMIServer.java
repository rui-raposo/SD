package aula7;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

    public static void main(String[] args) {

        System.setSecurityManager(new SecurityManager());
        try { //Iniciar a execução do registry no porto desejado
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.out.println("Exception starting RMI registry:");
            e.printStackTrace();
        }

        try {
            RMIImpl implementaInterface = new RMIImpl("RMIImpl");
            System.out.println("Servidor está OK");
        } catch (Exception e) {
            System.out.println("Erro no servidor " + e);
        }

    }

}
