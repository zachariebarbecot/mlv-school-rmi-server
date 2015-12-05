package impl;

import api.IBook;
import api.IUser;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class Book
        extends UnicastRemoteObject
        implements IBook, Serializable {

    private long isbn;
    private String title;
    private String author;
    private Date created;
    private ArrayList<IUser> userList;

    public Book()
            throws RemoteException {
        super();
        this.userList = new ArrayList<>();
    }

    public Book(long isbn, String title, String author)
            throws RemoteException {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.created = new Date();
        this.userList = new ArrayList<>();
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
    public synchronized String getTitle()
            throws RemoteException {
        return title;
    }

    @Override
    public synchronized void setTitle(String title)
            throws RemoteException {
        this.title = title;
    }

    @Override
    public synchronized String getAuthor()
            throws RemoteException {
        return author;
    }

    @Override
    public synchronized void setAuthor(String author)
            throws RemoteException {
        this.author = author;
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
    public synchronized ArrayList<IUser> getUserList() throws RemoteException {
        return userList;
    }

    @Override
    public synchronized void setUserList(ArrayList<IUser> userList) throws RemoteException {
        this.userList = userList;
    }

    @Override
    public synchronized void subscribe(IUser user) throws RemoteException {
        userList.add(user);
    }

    @Override
    public synchronized void unsubscribe(IUser user) throws RemoteException {
        userList.remove(user);
    }

    @Override
    public synchronized String display()
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
