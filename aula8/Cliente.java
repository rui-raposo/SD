package aula8;

import java.rmi.*;

public class Cliente extends java.rmi.server.UnicastRemoteObject implements Hello_C_I {

    public Cliente() throws RemoteException {
        super();
    }

    public void printOnClient(String s) throws java.rmi.RemoteException {
        System.out.println("Message from server: " + s);
    }

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());
        try {
            Hello_S_I h = (Hello_S_I) Naming.lookup("Hello");
            Cliente c = new Cliente();
            h.subscribe("Nome da máquina cliente ...", (Hello_C_I) c);
        } catch (Exception r) {
            System.out.println("Exception in client" + r.getMessage());
        }
    }
}
