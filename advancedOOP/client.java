
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {
    private client() {}
    
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry(null);
            // Look up the remote object
            Hello stub = (Hello) registry.lookup("Hello");
            // Call the remote method using the obtained object
            stub.printmag();
            // system.out.println("Remote method invoked successfully");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}