package library;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import waiting.IWaiting;

public interface ILibraryWaiting
        extends Remote {

    public void createWaiting(long waitingID, long isbn, long userID)
            throws RemoteException;

    public void deleteWaiting(long waitingID)
            throws RemoteException;

    public IWaiting findWaitingByWaitingID(long waitingID)
            throws RemoteException;

    public IWaiting findWaitingByIsbn(long isbn)
            throws RemoteException;

    public List<IWaiting> findWaitingByUserID(long userID)
            throws RemoteException;
}
