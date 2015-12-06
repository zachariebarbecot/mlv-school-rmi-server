package impl;

import api.IUser;
import api.ILibrary;
import api.ILoan;
import api.IBook;
import api.IComment;
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
    private HashMap<Long, Comment> comments;

    public Library() throws RemoteException {
        super();
        users = new HashMap<>();
        books = new HashMap<>();
        loans = new HashMap<>();
        comments = new HashMap<>();
    }

    @Override
    public synchronized void createUser(long userID, String lname, String fname, boolean status) throws RemoteException {
        if (this.findUserByUserID(userID) == null) {
            User user = new User(userID, lname, fname, status);
            users.put(userID, user);
        }
    }

    @Override
    public synchronized void deleteUser(long userID) throws RemoteException {
        if (this.findUserByUserID(userID) != null) {
            users.remove(userID);
        }
    }

    @Override
    public synchronized IUser findUserByUserID(long userID) throws RemoteException {
        return users.get(userID);
    }

    @Override
    public synchronized IUser findUserByFullName(String lname, String fname) throws RemoteException {
        for (Map.Entry<Long, User> entry : users.entrySet()) {
            if ((entry.getValue().getLName().equals(lname))
                    && (entry.getValue().getFName().equals(fname))) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public synchronized void createBook(long isbn, String title, String author) throws RemoteException {
        if (this.findBookByIsbn(isbn) == null) {
            Book book = new Book(isbn, title, author);
            books.put(isbn, book);
        }
    }

    @Override
    public synchronized void deleteBook(long isbn) throws RemoteException {
        if (this.findBookByIsbn(isbn) != null) {
            books.remove(isbn);
        }
    }

    @Override
    public synchronized List<IBook> findBookAll() throws RemoteException {
        List<IBook> booksList = new ArrayList<>();
        books.forEach((isbn, book) -> {
            booksList.add(book);
        });
        return booksList;
    }

    @Override
    public synchronized IBook findBookByIsbn(long isbn) throws RemoteException {
        return books.get(isbn);
    }

    @Override
    public synchronized List<IBook> findBookByTitle(String title) throws RemoteException {
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
    public synchronized List<IBook> findBookByAuthor(String author) throws RemoteException {
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
    public synchronized void createLoan(long isbn, long userID) throws RemoteException {
        if (this.findLoanByIsbn(isbn) == null) {
            Loan loan = new Loan(isbn, userID);
            loans.put(isbn, loan);
        } else {
            IBook book = findBookByIsbn(isbn);
            book.subscribe(findUserByUserID(userID));
        }
    }

    @Override
    public synchronized void deleteLoan(long isbn) throws RemoteException {
        if (this.findLoanByIsbn(isbn) != null) {
            loans.remove(isbn);
            IBook book = findBookByIsbn(isbn);
            if (!book.getUserList().isEmpty() && book.getUserList().get(0) != null) {
                createLoan(isbn, book.getUserList().get(0).getUserID());
                book.getUserList().remove(0);
            }

        }
    }

    @Override
    public synchronized ILoan findLoanByIsbn(long isbn) throws RemoteException {
        return loans.get(isbn);
    }

    @Override
    public synchronized List<ILoan> findLoanByUserID(long userID) throws RemoteException {
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
    public synchronized void createComment(long commentID, long isbn, String comment) throws RemoteException {
        if (this.findCommentByCommentID(commentID) == null) {
            Comment c = new Comment(commentID, isbn, comment);
            comments.put(commentID, c);
        }
    }

    @Override
    public synchronized void deleteComment(long commentID) throws RemoteException {
        if (this.findCommentByCommentID(commentID) != null) {
            comments.remove(commentID);
        }
    }

    @Override
    public synchronized IComment findCommentByCommentID(long commentID) throws RemoteException {
        for (Map.Entry<Long, Comment> entry : comments.entrySet()) {
            if (entry.getValue().getCommentID() == commentID) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public synchronized List<IComment> findCommentByIsbn(long isbn) throws RemoteException {
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
