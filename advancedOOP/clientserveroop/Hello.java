package clientserveroop;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {

    String registerStudent(String name) throws RemoteException;

}
