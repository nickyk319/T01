package com.example.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

@Path("Library")
public class LibraryRest {
    /**
     * Class for holding the list of books and handling the requests
     */

    private static ArrayList<Book> books = new ArrayList<>();

    /**
     * Meant for returning the list of books
     * @return A concatenation of the toString method for all books
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBook() {
        return books.stream().map(Object::toString).collect(Collectors.joining(".\n"));
    }

    /**
     * Meant for getting a book with a specific title
     * @param title of the book
     * @return toString method of book
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{title}")
    public String getBookTitle(@PathParam("title") String title) {
        for (Book book: books){
            if (book.getTitle().equals(title)) {
                return book.toString();
            }
        }
        return "Book not found!";
    }

    /**
     * Meant for creating books using the post method
     * @param title of the book
     * @param author of the book
     * @param isbn of the book
     */
    @POST
    @Path("{title}/{author}/{isbn}")
    public void createBook(@PathParam("title") String title, @PathParam("author") String author, @PathParam("isbn") String isbn) {
        Book newBook = new Book(title, author, isbn);
        books.add(newBook);
    }

    /**
     * Meant for modifying the book with specific ISBN
     * @param title of the book
     * @param author of the book
     * @param isbn of the book
     */
    @PUT
    @Path("{title}/{author}/{isbn}")
    public void modifyBook(@PathParam("title") String title, @PathParam("author") String author, @PathParam("isbn") String isbn) {
        boolean found = false;
        for (Book book: books){
            if (book.getIsbn().equals(isbn)){
                book.setAuthor(author);
                book.setTitle(title);
                found = true;
                break;
            }
        }
        if (!found){
            createBook(title,author,isbn);
        }

    }

    /**
     * Debugging statement that prints the current state of the list of customers
     */
    private void printBooks() {
        for(Book book: books) {
            System.out.println(book);
        }
    }
}