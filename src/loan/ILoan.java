package loan;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

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

    public Date getCreated()
            throws RemoteException;

    public void setCreated(Date created)
            throws RemoteException;

    public String display()
            throws RemoteException;
}
