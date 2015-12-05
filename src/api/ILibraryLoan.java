package api;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILibraryLoan
        extends Remote {

    public void createLoan(long isbn, long userID)
            throws RemoteException;

    public void deleteLoan(long isbn)
            throws RemoteException;

    public ILoan findLoanByIsbn(long isbn)
            throws RemoteException;

    public List<ILoan> findLoanByUserID(long userID)
            throws RemoteException;
}
