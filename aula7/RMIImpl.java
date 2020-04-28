package aula7;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class RMIImpl extends UnicastRemoteObject implements RMIInterface {
    
    private static int counter = 0;

    public RMIImpl(String name) throws RemoteException {
        super();
        
        try {
            Naming.rebind(name, this);
        } catch (Exception e) {
            if (e instanceof RemoteException) {
                throw (RemoteException) e;
            } else {
                throw new RemoteException(e.getMessage());
            }
        }
    }

    public java.util.Date getDate() {
        System.out.println(" Método remoto -- RMIImpl.getDate()");
        return new java.util.Date();
    }
    
    public int getCounter(){
        this.counter++;
        return counter;
    }
}
