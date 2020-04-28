package aula8;

public interface CidadeFactory extends java.rmi.Remote {
 public Cidade getServidorCidade (String nomeCidade) throws java.rmi.RemoteException;
}
