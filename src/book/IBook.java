package book;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface IBook
        extends Remote {

    public long getIsbn()
            throws RemoteException;

    public void setIsbn(long isbn)
            throws RemoteException;

    public String getTitle()
            throws RemoteException;

    public void setTitle(String title)
            throws RemoteException;

    public String getAuthor()
            throws RemoteException;

    public void setAuthor(String author)
            throws RemoteException;

    public Date getCreated()
            throws RemoteException;

    public void setCreated(Date created)
            throws RemoteException;

    public String display()
            throws RemoteException;
}
