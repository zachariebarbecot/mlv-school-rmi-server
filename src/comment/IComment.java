package comment;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

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

    public Date getCreated()
            throws RemoteException;

    public void setCreated(Date created)
            throws RemoteException;

    public String display()
            throws RemoteException;
}
