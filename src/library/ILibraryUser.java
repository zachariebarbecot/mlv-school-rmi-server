package library;

import java.rmi.Remote;
import java.rmi.RemoteException;
import user.IUser;

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
