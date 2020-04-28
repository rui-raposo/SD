package aula7;

import java.rmi.*;

public class CalculatorServer {

    public CalculatorServer() {
        
        System.setSecurityManager(new SecurityManager());
        try { //Iniciar a execução do registry no porto desejado
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.out.println("Exception starting RMI registry:");
            e.printStackTrace();
        }
        
        try {
            Calculator c = new CalculatorImpl();
            Naming.rebind("rmi://localhost:1099/CalculatorService", c);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

    public static void main(String[] args) {
        
        new CalculatorServer();
        
    }
}
