package aula8;

public class CidadeImpl extends java.rmi.server.UnicastRemoteObject implements Cidade {

    private String nomeCidade;
    int populacao = 20000;

    public CidadeImpl() throws java.rmi.RemoteException {
        super();
    }

    public CidadeImpl(String nomeCidade) throws java.rmi.RemoteException {
        super();
        this.nomeCidade = nomeCidade;
    }

    public int getPopulacao() throws java.rmi.RemoteException {
        return populacao;
    }

}


