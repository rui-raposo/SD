package aula7;

import java.rmi.*;

public class ServerEx6 {
    
    public ServerEx6(){
        
        System.setSecurityManager(new SecurityManager());
        try{
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            //System.out.println("RMI registry ready.");
        }catch (Exception e){
            //System.out.println("Exception starting RMI registry:");
            e.printStackTrace();
        }
        
        try{
            Ex6Interface imp = new Ex6Impl();
            Naming.rebind("rmi://localhost:1099/Register", imp);
        }catch(Exception e){
            System.out.println("Trouble: " + e);
        }
        
        
        
    }
    
    
    public static void main(String[] args) {
        
        new ServerEx6();
        
    }
    
}
