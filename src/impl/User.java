package impl;

import api.IUser;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class User
        extends UnicastRemoteObject
        implements IUser, Serializable {

    private long userID;
    private String lname;
    private String fname;
    private boolean status;
    private Date created;

    public User()
            throws RemoteException {
        super();
    }

    public User(long userID, String lname, String fname, boolean status)
            throws RemoteException {
        super();
        this.userID = userID;
        this.lname = lname;
        this.fname = fname;
        this.status = status;
        this.created = new Date();
    }

    @Override
    public synchronized long getUserID()
            throws RemoteException {
        return userID;
    }

    @Override
    public synchronized void setUserID(long userID)
            throws RemoteException {
        this.userID = userID;
    }

    @Override
    public synchronized String getLName()
            throws RemoteException {
        return lname;
    }

    @Override
    public synchronized void setLName(String lname)
            throws RemoteException {
        this.lname = lname;
    }

    @Override
    public synchronized String getFName()
            throws RemoteException {
        return fname;
    }

    @Override
    public synchronized void setFName(String fname)
            throws RemoteException {
        this.fname = fname;
    }

    @Override
    public synchronized boolean getStatus()
            throws RemoteException {
        return status;
    }

    @Override
    public synchronized void setStatus(boolean status)
            throws RemoteException {
        this.status = status;
    }

    @Override
    public synchronized Date getCreated()
            throws RemoteException {
        return created;
    }

    @Override
    public synchronized void setCreated(Date created)
            throws RemoteException {
        this.created = created;
    }

    @Override
    public void update(long isbn)
            throws RemoteException {
        
    }

    @Override
    public synchronized String display()
            throws RemoteException {
        return "{'User':"
                + "{"
                + "'userID': '" + userID + "', "
                + "'lname': '" + lname + "', "
                + "'fname': '" + fname + "', "
                + "'status': '" + status + "', "
                + "'created': '" + created + "'"
                + "}"
                + "}";
    }

}
