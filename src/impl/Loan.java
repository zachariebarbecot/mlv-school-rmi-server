package impl;

import api.ILoan;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class Loan
        extends UnicastRemoteObject
        implements ILoan, Serializable {

    private long isbn;
    private long userID;
    private LocalDateTime created;

    public Loan()
            throws RemoteException {
        super();
    }

    public Loan(long isbn, long userID)
            throws RemoteException {
        super();
        this.isbn = isbn;
        this.userID = userID;
        this.created = LocalDateTime.now();
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
    public synchronized LocalDateTime getCreated()
            throws RemoteException {
        return created;
    }

    @Override
    public synchronized void setCreated(LocalDateTime created)
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
