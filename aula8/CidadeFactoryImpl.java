package aula8;

import java.rmi.RemoteException;

public class CidadeFactoryImpl extends java.rmi.server.UnicastRemoteObject implements CidadeFactory {

    public CidadeFactoryImpl() throws java.rmi.RemoteException {
        super();
    }

    public Cidade getServidorCidade(String nomeCidade) throws java.rmi.RemoteException {
        CidadeImpl ServidorCidade = new CidadeImpl(nomeCidade);
        return (Cidade) ServidorCidade;
    }

    public static void main(String[] args) throws RemoteException {
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        try {
            CidadeFactory factory = new CidadeFactoryImpl();
            java.rmi.Naming.rebind("CidadeFactory", factory);
            System.out.println("CidadeFactory registada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
