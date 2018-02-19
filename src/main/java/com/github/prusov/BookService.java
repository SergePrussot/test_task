package com.github.prusov;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.github.prusov.Book.class })
public interface BookService {
    public abstract long countAllBooks(String searchString);
}
