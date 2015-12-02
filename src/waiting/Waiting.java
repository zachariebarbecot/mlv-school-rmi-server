package waiting;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Waiting
        extends UnicastRemoteObject
        implements IWaiting, Serializable {

    private long waitingID;
    private long isbn;
    private long userID;
    private Date created;

    public Waiting()
            throws RemoteException {
    }

    public Waiting(long waitingID, long isbn, long userID)
            throws RemoteException {
        this.waitingID = waitingID;
        this.isbn = isbn;
        this.userID = userID;
        this.created = new Date();
    }

    @Override
    public long getWaitingID()
            throws RemoteException {
        return waitingID;
    }

    @Override
    public void setWaitingID(long waitingID)
            throws RemoteException {
        this.waitingID = waitingID;
    }

    @Override
    public long getIsbn()
            throws RemoteException {
        return isbn;
    }

    @Override
    public void setIsbn(long isbn)
            throws RemoteException {
        this.isbn = isbn;
    }

    @Override
    public long getUserID()
            throws RemoteException {
        return userID;
    }

    @Override
    public void setUserID(long userID)
            throws RemoteException {
        this.userID = userID;
    }

    @Override
    public Date getCreated() throws RemoteException {
        return created;
    }

    @Override
    public void setCreated(Date created) throws RemoteException {
        this.created = created;
    }

    @Override
    public String display() throws RemoteException {
        return "{'Waiting':"
                + "{"
                + "'loanID': '" + waitingID + "', "
                + "'isbn': '" + isbn + "', "
                + "'userID': '" + userID + "', "
                + "'created': '" + created + "'"
                + "}"
                + "}";
    }
}
