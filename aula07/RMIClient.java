package aula07;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.Date;
public class RMIClient{
    
    public static void main(String[] argv) {
        String serverName = "";
        System.setSecurityManager(new SecurityManager());
        if (argv.length != 1) {
            try {
                serverName = java.net.InetAddress.getLocalHost().getHostName();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        else {
            serverName = argv[0];
        }
        if (serverName.equals( "") ) {
            System.out.println("usage: java RMIClient < host running RMI server>");
            System.exit(0);
        }
        
        try {
            //bind server object to object in client
            RMIInterface myServerObject =
            (RMIInterface) Naming.lookup("//"+serverName+"/RMIImpl");
            //invoke method on server object
            Date d = myServerObject.getDate();
            System.out.println("Date on server is " + d);
            System.out.println("Number : " + myServerObject.getCounter());
        }
        catch(Exception e) {
            System.out.println("Exception occured: " + e);
            System.exit(0);
        }
        
        System.out.println("RMI connection successful");
    
    }
}
