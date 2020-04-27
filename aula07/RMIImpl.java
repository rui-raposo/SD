
package aula07;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class RMIImpl extends UnicastRemoteObject implements RMIInterface {

    static private int counter = 0;
            
    public RMIImpl(String name) throws RemoteException {
        super();
        try {
            Naming.rebind(name, this);
        }
        catch (Exception e) {
            
            if (e instanceof RemoteException)
                throw (RemoteException)e;
            else
                throw new RemoteException(e.getMessage());
        }
        }
    
    
        public java.util.Date getDate() {
        System.out.println(" Método remoto -- RMIImpl.getDate()");
        return new java.util.Date();
        }
        
        public String getCounter(){
            return counter;
        }
}
