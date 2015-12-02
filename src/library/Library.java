package library;

import waiting.*;
import user.*;
import loan.*;
import comment.*;
import book.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Library
        extends UnicastRemoteObject
        implements ILibrary, Serializable {

    private HashMap<Long, User> users;
    private HashMap<Long, Book> books;
    private HashMap<Long, Loan> loans;
    private HashMap<Long, Waiting> waitings;
    private HashMap<Long, Comment> comments;

    public Library() throws RemoteException {
        super();
        users = new HashMap<>();
        books = new HashMap<>();
        loans = new HashMap<>();
        waitings = new HashMap<>();
        comments = new HashMap<>();
    }

    @Override
    public void createUser(long userID, String lname, String fname, boolean status) throws RemoteException {
        if (this.findUserByUserID(userID) == null) {
            User user = new User(userID, lname, fname, status);
            users.put(userID, user);
        }
    }

    @Override
    public void deleteUser(long userID) throws RemoteException {
        if (this.findUserByUserID(userID) != null) {
            users.remove(userID);
        }
    }

    @Override
    public IUser findUserByUserID(long userID) throws RemoteException {
        return users.get(userID);
    }

    @Override
    public IUser findUserByFullName(String lname, String fname) throws RemoteException {
        for (Map.Entry<Long, User> entry : users.entrySet()) {
            if ((entry.getValue().getLName().equals(lname))
                    && (entry.getValue().getFName().equals(fname))) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void createBook(long isbn, String title, String author) throws RemoteException {
        if (this.findBookByIsbn(isbn) == null) {
            Book book = new Book(isbn, title, author);
            books.put(isbn, book);
        }
    }

    @Override
    public void deleteBook(long isbn) throws RemoteException {
        if (this.findBookByIsbn(isbn) != null) {
            books.remove(isbn);
        }
    }

    @Override
    public IBook findBookByIsbn(long isbn) throws RemoteException {
        return books.get(isbn);
    }

    @Override
    public List<IBook> findBookByTitle(String title) throws RemoteException {
        List<IBook> booksList = new ArrayList<>();
        books.forEach((isbn, book) -> {
            try {
                if (book.getTitle().equals(title)) {
                    booksList.add(book);
                }
            } catch (RemoteException e) {
                System.out.println("Trouble: " + e);
            }
        });
        return booksList;
    }

    @Override
    public List<IBook> findBookByAuthor(String author) throws RemoteException {
        List<IBook> booksList = new ArrayList<>();
        books.forEach((isbn, book) -> {
            try {
                if (book.getAuthor().equals(author)) {
                    booksList.add(book);
                }
            } catch (RemoteException e) {
                System.out.println("Trouble: " + e);
            }
        });
        return booksList;
    }

    @Override
    public void createLoan(long isbn, long userID) throws RemoteException {
        if (this.findLoanByIsbn(isbn) == null) {
            Loan loan = new Loan(isbn, userID);
            loans.put(isbn, loan);
        }
    }

    @Override
    public void deleteLoan(long isbn) throws RemoteException {
        if (this.findLoanByIsbn(isbn) != null) {
            loans.remove(isbn);
        }
    }

    @Override
    public ILoan findLoanByIsbn(long isbn) throws RemoteException {
        return loans.get(isbn);
    }

    @Override
    public List<ILoan> findLoanByUserID(long userID) throws RemoteException {
        List<ILoan> loansList = new ArrayList<>();
        loans.forEach((isbn, loan) -> {
            try {
                if (loan.getUserID() == userID) {
                    loansList.add(loan);
                }
            } catch (RemoteException e) {
                System.out.println("Trouble: " + e);
            }
        });
        return loansList;
    }

    @Override
    public void createWaiting(long waitingID, long isbn, long userID) throws RemoteException {
        if (this.findWaitingByWaitingID(waitingID) == null) {
            Waiting waiting = new Waiting(waitingID, isbn, userID);
            waitings.put(waitingID, waiting);
        }
    }

    @Override
    public void deleteWaiting(long waitingID) throws RemoteException {
        if (this.findWaitingByWaitingID(waitingID) != null) {
            waitings.remove(waitingID);
        }
    }

    @Override
    public IWaiting findWaitingByWaitingID(long waitingID) throws RemoteException {
        return waitings.get(waitingID);
    }

    @Override
    public IWaiting findWaitingByIsbn(long isbn) throws RemoteException {
        for (Map.Entry<Long, Waiting> entry : waitings.entrySet()) {
            if (entry.getValue().getIsbn() == isbn) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public List<IWaiting> findWaitingByUserID(long userID) throws RemoteException {
        List<IWaiting> waitingsList = new ArrayList<>();
        waitings.forEach((waitingID, waiting) -> {
            try {
                if (waiting.getUserID() == userID) {
                    waitingsList.add(waiting);
                }
            } catch (RemoteException e) {
                System.out.println("Trouble: " + e);
            }
        });
        return waitingsList;
    }

    @Override
    public void createComment(long commentID, long isbn, String comment) throws RemoteException {
        if (this.findCommentByCommentID(commentID) == null) {
            Comment c = new Comment(commentID, isbn, comment);
            comments.put(commentID, c);
        }
    }

    @Override
    public void deleteComment(long commentID) throws RemoteException {
        if (this.findCommentByCommentID(commentID) != null) {
            comments.remove(commentID);
        }
    }

    @Override
    public IComment findCommentByCommentID(long commentID) throws RemoteException {
        for (Map.Entry<Long, Comment> entry : comments.entrySet()) {
            if (entry.getValue().getCommentID() == commentID) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public List<IComment> findCommentByIsbn(long isbn) throws RemoteException {
        List<IComment> commentsList = new ArrayList<>();
        comments.forEach((commentID, comment) -> {
            try {
                if (comment.getIsbn() == isbn) {
                    commentsList.add(comment);
                }
            } catch (RemoteException e) {
                System.out.println("Trouble: " + e);
            }
        });
        return commentsList;
    }
}
