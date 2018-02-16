package com.github.prusov;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Book {

    /**
     */
    @NotNull
    private String title;

    /**
     */
    private String description;

    /**
     */
    @NotNull
    private String author;

    /**
     */
    @NotNull
    private String isbn;

    /**
     */
    @NotNull
    private int printYear;

    /**
     */
    @NotNull
    private Boolean readAlready;
}
