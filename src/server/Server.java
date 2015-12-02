package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import library.ILibrary;
import library.Library;

public class Server {

    private static final int PORT = 1099;

    public static void main(String[] args)
            throws RemoteException, MalformedURLException {
        System.setProperty("java.security.policy", "bin/java.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        LocateRegistry.createRegistry(PORT);
        ILibrary library = new Library();
        /*
         * BEGIN TEST
         */
        createUser(library);
        createBook(library);
        createLoan(library);
        /*
         * END TEST
         */
        String url = "rmi://localhost:" + PORT + "/library";
        Naming.rebind(url, library);
        System.out.println("Library Server started on: " + url);
    }

    private static void createUser(ILibrary library)
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

    private static void createBook(ILibrary library)
            throws RemoteException {
        library.createBook(266208918, "Dragon Rouge", "Thomas HARRIS");
        library.createBook(290071823, "La stratégie Ender", "Orson SCOTT CARD");
        library.createBook(290312926, "La voix des morts", "Orson SCOTT CARD");
    }

    private static void createLoan(ILibrary library)
            throws RemoteException {
        library.createLoan(290312926, 100);
    }
}
