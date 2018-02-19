package com.github.prusov;

public class BookServiceImpl implements BookService {
    public Book updateBook(Book book) {
        Book prevBook = Book.findBook(book.getId());
        if (!prevBook.getAuthor().equals(book.getAuthor())) {
            book.setAuthor(prevBook.getAuthor());
        }
        boolean somethingChanged = false;
        if (!prevBook.getTitle().equals(book.getTitle())) {
            somethingChanged = true;
        }
        if (!prevBook.getDescription().equals(book.getDescription())) {
            somethingChanged = true;
        }
        if (!prevBook.getIsbn().equals(book.getIsbn())) {
            somethingChanged = true;
        }
        if (prevBook.getPrintYear() != book.getPrintYear()) {
            somethingChanged = true;
        }
        if (somethingChanged) {
            book.setReadAlready(false);
        } else if (!book.getReadAlready()) {
            book.setReadAlready(true);
        }
        return book.merge();
    }

    public long countAllBooks(String searchString) {
        return Book.countBooks(searchString);
    }

}

