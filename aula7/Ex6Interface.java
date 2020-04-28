package aula7;

public interface Ex6Interface extends java.rmi.Remote{
    
    // methods
    public String register(String name, int std_number, int phone_number) throws java.rmi.RemoteException;
    public String listStudents() throws java.rmi.RemoteException;
    
}
