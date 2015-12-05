package api;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILibraryComment
        extends Remote {

    public void createComment(long commentID, long isbn, String comment)
            throws RemoteException;

    public void deleteComment(long commentID)
            throws RemoteException;

    public IComment findCommentByCommentID(long commentID)
            throws RemoteException;

    public List<IComment> findCommentByIsbn(long isbn)
            throws RemoteException;
}
