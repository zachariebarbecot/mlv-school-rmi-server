package server;

import api.ILibrary;
import java.rmi.RemoteException;

public abstract class AbstractApp {

    protected static void createUser(ILibrary library)
            throws RemoteException {
        library.createUser(100, "BARBECOT", "Zacharie", false);
        library.createUser(101, "BERTILLE", "Didier", false);
        library.createUser(102, "KRIDANE", "Sara", false);
        library.createUser(103, "TRAN", "Maxime", false);

        library.createUser(200, "MIDONNET", "Serge", true);
        library.createUser(201, "VARACCA", "Daniele", true);
        library.createUser(202, "ZARGAYOUNA", "Mahdi", true);
        library.createUser(203, "CHILOWICZ", "Michel", true);
    }

    protected static void createBook(ILibrary library)
            throws RemoteException {
        library.createBook(266208918, "Dragon Rouge", "Thomas HARRIS");
        library.createBook(290071823, "La stratégie Ender", "Orson SCOTT CARD");
        library.createBook(290312926, "La voix des morts", "Orson SCOTT CARD");
        library.createBook(290075465, "La stratégie Ender Bis", "Orson SCOTT CARD", 99);
        library.createBook(290316546, "La voix des morts Ter", "Orson SCOTT CARD", 50);
    }

    protected static void createLoan(ILibrary library)
            throws RemoteException {
        library.createLoan(290312926, 100);
    }

    protected static void createComment(ILibrary library)
            throws RemoteException {
        library.createComment(01, 290312926, "Super Livre.");
    }
}
