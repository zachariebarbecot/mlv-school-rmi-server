package comment;

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
    }

    public Comment(long commentID, long isbn, String comment)
            throws RemoteException {
        this.commentID = commentID;
        this.isbn = isbn;
        this.comment = comment;
        this.created = new Date();
    }

    @Override
    public long getCommentID()
            throws RemoteException {
        return commentID;
    }

    @Override
    public void setCommentID(long commentID)
            throws RemoteException {
        this.commentID = commentID;
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
    public String getComment()
            throws RemoteException {
        return comment;
    }

    @Override
    public void setComment(String comment)
            throws RemoteException {
        this.comment = comment;
    }

    @Override
    public Date getCreated()
            throws RemoteException {
        return created;
    }

    @Override
    public void setCreated(Date created)
            throws RemoteException {
        this.created = created;
    }

    @Override
    public String display()
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
