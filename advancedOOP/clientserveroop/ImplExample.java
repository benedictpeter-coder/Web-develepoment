package clientserveroop;

import java.rmi.RemoteException;

public class ImplExample implements Hello {

    @Override
    public String registerStudent(String name) throws RemoteException {
        return "Student " + name + " registered successfully";
    }
}
