package clientserveroop;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {

    private client(){}

    public static void main(String[] args) {

        try {

            Registry registry =
                    LocateRegistry.getRegistry("localhost");

            Hello stub =
                    (Hello) registry.lookup("Hello");

            String response =
                    stub.registerStudent("Benedict");

            System.out.println(response);

        } catch (Exception e){

            System.out.println("Client error " + e);

        }

    }
}
