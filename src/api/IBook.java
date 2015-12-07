package api;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    public int getCounter()
            throws RemoteException;

    public void setCounter(int counter)
            throws RemoteException;

    public LocalDateTime getCreated()
            throws RemoteException;

    public void setCreated(LocalDateTime created)
            throws RemoteException;

    public ArrayList<IUser> getUserList()
            throws RemoteException;

    public void setUserList(ArrayList<IUser> userList)
            throws RemoteException;

    public void subscribe(IUser user)
            throws RemoteException;

    public void unsubscribe(IUser user)
            throws RemoteException;

    public String display()
            throws RemoteException;
}
