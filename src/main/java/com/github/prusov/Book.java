package com.github.prusov;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Book {

    /**
     */
    @NotNull
    @Size(max = 100)
    private String title;

    /**
     */
    @Size(max = 255)
    private String description;

    /**
     */
    @NotNull
    @Size(max = 100)
    private String author;

    /**
     */
    @NotNull
    @Size(max = 20)
    private String isbn;

    /**
     */
    @NotNull
    @Digits(integer = 4, fraction = 0, message = "{javax.validation.constraints.Digits.message}")
    private int printYear;

    /**
     */
    @NotNull
    private Boolean readAlready;

    public static List<Book> findBookEntries(int firstResult,
                                             int maxResults,
                                             String sortFieldName,
                                             String sortOrder,
                                             String searchQuery) {
        String jpaQuery = "SELECT o FROM Book o WHERE title LIKE '%" + searchQuery + "%'";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Book.class).setFirstResult(firstResult).setMaxResults(maxResults)
                .getResultList();
    }

    public static long countBooks(String searchQuery) {
        return entityManager()
                .createQuery("SELECT COUNT(o) FROM Book o WHERE title LIKE '%" + searchQuery + "%'", Long.class)
                .getSingleResult();
    }

}

