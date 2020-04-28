package aula7;

import java.util.Date;

public interface RMIInterface extends java.rmi.Remote {

     public java.util.Date getDate() throws java.rmi.RemoteException;
     public int getCounter() throws java.rmi.RemoteException;
}
