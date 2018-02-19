package com.github.prusov;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/books")
@Controller
@RooWebScaffold(path = "books", formBackingObject = Book.class)
public class BookController {
    @RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page,
                       @RequestParam(value = "size", required = false) Integer size,
                       @RequestParam(value = "sortFieldName", required = false) String sortFieldName,
                       @RequestParam(value = "sortOrder", required = false) String sortOrder,
                       @RequestParam(value = "q", required = false) String searchString,
                       Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            if (searchString != null) {
                uiModel.addAttribute("books", Book.findBookEntries(firstResult, sizeNo, sortFieldName, sortOrder, searchString));
                float nrOfPages = (float) bookService.countAllBooks(searchString) / sizeNo;
                uiModel.addAttribute("maxPages",
                        (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
            } else {
                uiModel.addAttribute("books", Book.findBookEntries(firstResult, sizeNo, sortFieldName, sortOrder));
                float nrOfPages = (float) bookService.countAllBooks() / sizeNo;
                uiModel.addAttribute("maxPages",
                        (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
            }
        } else {
            uiModel.addAttribute("books", Book.findAllBooks(sortFieldName, sortOrder));
        }
        return "books/list";
    }
}

