// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.github.prusov;

import com.github.prusov.Book;
import com.github.prusov.BookServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect BookServiceImpl_Roo_Service {
    
    declare @type: BookServiceImpl: @Service;
    
    declare @type: BookServiceImpl: @Transactional;
    
    public long BookServiceImpl.countAllBooks() {
        return Book.countBooks();
    }
    
    public void BookServiceImpl.deleteBook(Book book) {
        book.remove();
    }
    
    public Book BookServiceImpl.findBook(Long id) {
        return Book.findBook(id);
    }
    
    public List<Book> BookServiceImpl.findAllBooks() {
        return Book.findAllBooks();
    }
    
    public List<Book> BookServiceImpl.findBookEntries(int firstResult, int maxResults) {
        return Book.findBookEntries(firstResult, maxResults);
    }
    
    public void BookServiceImpl.saveBook(Book book) {
        book.persist();
    }
    
}
