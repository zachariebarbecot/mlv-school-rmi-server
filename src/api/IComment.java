package api;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface IComment
        extends Remote {

    public long getCommentID()
            throws RemoteException;

    public void setCommentID(long commentID)
            throws RemoteException;

    public long getIsbn()
            throws RemoteException;

    public void setIsbn(long isbn)
            throws RemoteException;

    public String getComment()
            throws RemoteException;

    public void setComment(String comment)
            throws RemoteException;

    public LocalDateTime getCreated()
            throws RemoteException;

    public void setCreated(LocalDateTime created)
            throws RemoteException;

    public String display()
            throws RemoteException;
}
