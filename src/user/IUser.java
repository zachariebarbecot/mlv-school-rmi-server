package user;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface IUser
        extends Remote {

    public long getUserID()
            throws RemoteException;

    public void setUserID(long userID)
            throws RemoteException;

    public String getLName()
            throws RemoteException;

    public void setLName(String lname)
            throws RemoteException;

    public String getFName()
            throws RemoteException;

    public void setFName(String fname)
            throws RemoteException;

    public boolean getStatus()
            throws RemoteException;

    public void setStatus(boolean status)
            throws RemoteException;

    public Date getCreated()
            throws RemoteException;

    public void setCreated(Date created)
            throws RemoteException;

    public String display()
            throws RemoteException;

}
