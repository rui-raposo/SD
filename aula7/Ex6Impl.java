package aula7;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Ex6Impl extends java.rmi.server.UnicastRemoteObject implements Ex6Interface{
    
    private ArrayList<Aluno> list;
    
    public Ex6Impl() throws RemoteException{
        super();
        this.list = new ArrayList();
    }
    
    public String register(String name, int std_number, int mobile_number) throws java.rmi.RemoteException{
        list.add(new Aluno(name, std_number, mobile_number));
        return "Success.";
    }
    
    public String listStudents() throws java.rmi.RemoteException{
        String var = "";
        for(Aluno i : list)
            var += "Name : " + i.getName();
        return var;
    }

    public void register() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
