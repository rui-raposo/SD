
package aula07;
public interface RMIInterface extends java.rmi.Remote {
    
    public java.util.Date getDate() throws java.rmi.RemoteException;

    public String getCounter() throws java.rmi.RemoteException;
    
    
}
