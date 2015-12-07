package api;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface ILoan
        extends Remote {

    public long getIsbn()
            throws RemoteException;

    public void setIsbn(long isbn)
            throws RemoteException;

    public long getUserID()
            throws RemoteException;

    public void setUserID(long userID)
            throws RemoteException;

    public LocalDateTime getCreated()
            throws RemoteException;

    public void setCreated(LocalDateTime created)
            throws RemoteException;

    public String display()
            throws RemoteException;
}
