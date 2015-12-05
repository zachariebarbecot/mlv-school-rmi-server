package impl;

import api.ILoan;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Loan
        extends UnicastRemoteObject
        implements ILoan, Serializable {

    private long isbn;
    private long userID;
    private Date created;

    public Loan()
            throws RemoteException {
        super();
    }

    public Loan(long isbn, long userID)
            throws RemoteException {
        super();
        this.isbn = isbn;
        this.userID = userID;
        this.created = new Date();
    }

    @Override
    public synchronized long getIsbn()
            throws RemoteException {
        return isbn;
    }

    @Override
    public synchronized void setIsbn(long isbn)
            throws RemoteException {
        this.isbn = isbn;
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
    public synchronized String display() throws RemoteException {
        return "{'Loan':"
                + "{"
                + "'isbn': '" + isbn + "', "
                + "'userID': '" + userID + "', "
                + "'created': '" + created + "'"
                + "}"
                + "}";
    }

}
