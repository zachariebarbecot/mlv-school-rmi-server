package api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILibraryUser
        extends Remote {

    public void createUser(long userID, String lname,
            String fname, boolean status)
            throws RemoteException;

    public void deleteUser(long userID)
            throws RemoteException;

    public IUser findUserByUserID(long userID)
            throws RemoteException;

    public IUser findUserByFullName(String lname, String fname)
            throws RemoteException;
}
