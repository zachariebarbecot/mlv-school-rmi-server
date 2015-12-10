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
        library.createBook(221073843, "Xénocine", "Orson SCOTT CARD");
        library.createBook(290305456, "Les Enfants de l'esprit", "Orson SCOTT CARD");

        library.createBook(753421638, "La Communauté de l'Anneau", "J. R. R. TOLKIEN", 5);
        library.createBook(345248282, "Les Deux Tours", "J. R. R. TOLKIEN", 5);
        library.createBook(007117116, "Le Retour du Roi", "J. R. R. TOLKIEN", 5);

        library.createBook(221026020, "Dune", "Frank HERBERT", 10);
        library.createBook(221026012, "Le Messie de Dune", "Frank HERBERT", 10);
        library.createBook(221000455, "Les Enfants de Dune", "Frank HERBERT", 10);
        library.createBook(221007751, "L’Empereur-Dieu de Dune", "Frank HERBERT", 10);
        library.createBook(221046420, "Les Hérétiques de Dune", "Frank HERBERT", 10);
        library.createBook(221049128, "La Maison des mères", "Frank HERBERT", 10);
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
