package book;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Book
        extends UnicastRemoteObject
        implements IBook, Serializable {

    private long isbn;
    private String title;
    private String author;
    private Date created;

    public Book()
            throws RemoteException {
        super();
    }

    public Book(long isbn, String title, String author)
            throws RemoteException {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.created = new Date();
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
    public String getTitle()
            throws RemoteException {
        return title;
    }

    @Override
    public void setTitle(String title)
            throws RemoteException {
        this.title = title;
    }

    @Override
    public String getAuthor()
            throws RemoteException {
        return author;
    }

    @Override
    public void setAuthor(String author)
            throws RemoteException {
        this.author = author;
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
        return "{'Book':"
                + "{"
                + "'isbn': '" + isbn + "', "
                + "'title': '" + title + "', "
                + "'author': '" + author + "', "
                + "'created': '" + created + "'"
                + "}"
                + "}";
    }

}
