package impl;

import api.IComment;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Comment
        extends UnicastRemoteObject
        implements IComment, Serializable {

    private long commentID;
    private long isbn;
    private String comment;
    private Date created;

    public Comment()
            throws RemoteException {
        super();
    }

    public Comment(long commentID, long isbn, String comment)
            throws RemoteException {
        super();
        this.commentID = commentID;
        this.isbn = isbn;
        this.comment = comment;
        this.created = new Date();
    }

    @Override
    public synchronized long getCommentID()
            throws RemoteException {
        return commentID;
    }

    @Override
    public synchronized void setCommentID(long commentID)
            throws RemoteException {
        this.commentID = commentID;
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
    public synchronized String getComment()
            throws RemoteException {
        return comment;
    }

    @Override
    public synchronized void setComment(String comment)
            throws RemoteException {
        this.comment = comment;
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
    public synchronized String display()
            throws RemoteException {
        return "{'Comment':"
                + "{"
                + "'commentID': '" + commentID + "', "
                + "'isbn': '" + isbn + "', "
                + "'comment': '" + comment + "', "
                + "'created': '" + created + "'"
                + "}"
                + "}";
    }
}
