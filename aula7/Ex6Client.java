package aula7;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Ex6Client {

    public static void main(String[] args) throws NotBoundException, MalformedURLException {
        
        try {
            Ex6Interface inter_face = (Ex6Interface) Naming.lookup("rmi://localhost:1099/Register");
            
            boolean aux = true;
            // loop
            while(aux){
                
                System.out.println("--------------------------------");
                System.out.println("--------------------------------");
                System.out.println("WELCOME");
                System.out.println("--------------------------------");
                System.out.println("--------------------------------");
                System.out.println("Choose an option:");
                System.out.println("1 - Regist a new student.");
                System.out.println("2 - List all the students.");
                System.out.println("3 - Not working yet.");
                System.out.println("0 - Exit");
                System.out.println("--------------------------------");
                
                String choice = Ler.umaString();
                
                switch(choice){
                    case "1" : 
                        System.out.print("Name: ");
                        String name = Ler.umaString();
                        System.out.print("Number: ");
                        int std_number = Ler.umInt();
                        System.out.print("Phone number: ");
                        int phone_number = Ler.umInt();
                        System.out.println(inter_face.register(name, std_number, phone_number));
                        break;
                    case "2" :
                        System.out.println(inter_face.listStudents());
                        break;
                    case "0" :
                        aux = false;
                        break;
                    default :
                        break;
                }

            }
            
        } catch (RemoteException re) {
            System.out.println("RemoteException");
            System.out.println(re.getMessage());
        }
        
    }
    
}
