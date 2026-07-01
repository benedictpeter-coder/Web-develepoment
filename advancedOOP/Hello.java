import java .rmi.Remote;
import java.rmi.RemoteException;

// creating remote interface for our RMI application
public interface Hello extends Remote {
    void printmag() throws RemoteException;
}
