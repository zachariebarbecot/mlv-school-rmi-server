package impl;

import api.IBook;
import api.IUser;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Book
        extends UnicastRemoteObject
        implements IBook, Serializable {

    private long isbn;
    private String title;
    private String author;
    private int counter;
    private LocalDateTime created;
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
        this.counter = 0;
        this.created = LocalDateTime.now();
        this.userList = new ArrayList<>();
    }

    public Book(long isbn, String title, String author, int counter)
            throws RemoteException {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.counter = counter;
        this.created = LocalDateTime.of(2005, 12, 18, 14, 30);
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
    public synchronized int getCounter()
            throws RemoteException {
        return counter;
    }

    @Override
    public synchronized void setCounter(int counter)
            throws RemoteException {
        this.counter = counter;
    }

    @Override
    public synchronized LocalDateTime getCreated()
            throws RemoteException {
        return created;
    }

    @Override
    public synchronized void setCreated(LocalDateTime created)
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
