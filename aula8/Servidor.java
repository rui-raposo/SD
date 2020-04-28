package aula8;

import java.rmi.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Servidor extends java.rmi.server.UnicastRemoteObject implements Hello_S_I {

    private static Hello_C_I client;
    private static int sorteio;
    private static ArrayList<Hello_C_I> list = new ArrayList<>();

    public Servidor() throws java.rmi.RemoteException {
        super();
    }

    //Método remoto
    public void printOnServer(String s) throws java.rmi.RemoteException {
        System.out.println(" SERVER : " + s);
    }
    //Método remoto

    public void subscribe(String name, Hello_C_I c) throws java.rmi.RemoteException {
        System.out.println("Subscribing " + name);
        client = c;
        // add in list
        list.add(c);
        if(list.size() % 3 == 0){
            this.sorteio();
            Hello_C_I winner = list.get(list.size()- 3 + sorteio);
            winner.printOnClient("Congratulations, you are the winner.");
            System.out.println("Winner : " + (sorteio+1));
        }
    }
    
    //Método local
    public void sorteio(){
        Random r = new Random();
        this.sorteio = r.nextInt(3);
    }

    //Método local
    public static String lerString() {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1);
            s = in.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    public static void main(String[] args) throws RemoteException {
        String s;
        System.setSecurityManager(new SecurityManager());
        
        // Exercise
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        
        try {
            Servidor h = new Servidor();
            Naming.rebind("Hello", h);
            while (true) {
                System.out.println("Mensagem para o cliente:");
                s = lerString();
                client.printOnClient(s);
            }
        } catch (RemoteException r) {
            System.out.println("Exception in server" + r.getMessage());
        } catch (java.net.MalformedURLException u) {
            System.out.println("Exception in server - URL");
        }
    }

}
