package aula8;

import java.rmi.Naming;
import java.rmi.Remote;

public class CidadeCliente {

    public static void main(String[] args) {
        Remote cidades = null;
        Cidade Covilha = null, CasteloBranco = null, Guarda = null;
        try {
            cidades = Naming.lookup("//127.0.0.1/CidadeFactory");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // criar um servidor para cada cidade
        try {
            Covilha = ((CidadeFactory) cidades).getServidorCidade("Covilha");
            CasteloBranco = ((CidadeFactory) cidades).getServidorCidade("CasteloBranco");
            Guarda = ((CidadeFactory) cidades).getServidorCidade("Guarda");
        }
        catch (Exception e){
        System.out.println(e.getMessage());
        }
        
        //invocar métodos nesses objectos
        try {
            int i = Covilha.getPopulacao();
            System.out.println("Covilhã tem " + i + " habitantes");
            i = CasteloBranco.getPopulacao();
            System.out.println("Castelo Branco tem " + i + " habitantes");
            i = Guarda.getPopulacao();
            System.out.println("Guarda tem " + i + " habitantes");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}