package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import library.ILibrary;
import library.Library;

public class App extends AbstractApp {

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
         * POPULATE SERVER
         */
        createUser(library);
        createBook(library);
        createLoan(library);
        createComment(library);
        /*
         * START SERVER
         */
        String url = "rmi://localhost:" + PORT + "/library";
        Naming.rebind(url, library);
        System.out.println("Library Server started on: " + url);
    }

}
