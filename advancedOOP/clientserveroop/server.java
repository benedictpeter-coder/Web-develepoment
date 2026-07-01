package clientserveroop;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class server {


    public static void main(String[] args) {
        try {
            ImplExample obj = new ImplExample();

            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.bind("Hello", stub);

            System.out.println("Server ready");

        } catch (Exception e) {
            System.out.println("Server error " + e);
        }
    }
}
