package library;

import book.IBook;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILibraryBook
        extends Remote {

    public void createBook(long isbn, String title, String author)
            throws RemoteException;

    public void deleteBook(long isbn)
            throws RemoteException;

    public IBook findBookByIsbn(long isbn)
            throws RemoteException;

    public List<IBook> findBookByTitle(String title)
            throws RemoteException;

    public List<IBook> findBookByAuthor(String author)
            throws RemoteException;
}
