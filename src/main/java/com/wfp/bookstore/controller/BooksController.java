package  com.wfp.bookstore.controller;


import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import   com.wfp.bookstore.entity.Book;
import com.wfp.bookstore.repository.BookRepository;
import com.wfp.bookstore.repository.UserRepository;
import com.wfp.bookstore.security.services.BookService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.*;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:8081")
public class BooksController {
    
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    

    @PostMapping("/books/create")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Results are ok", content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = BookRepository.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid request",
                content = @Content),
        @ApiResponse(responseCode = "401", description = "Unauthorised or Invalid token request",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Resource not found",
                content = @Content) })
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        
        return new ResponseEntity<>(bookService.save(book) , HttpStatus.CREATED);
    }


    @PutMapping("/books/update/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Results are ok", content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = BookRepository.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid request",
                content = @Content),
        @ApiResponse(responseCode = "401", description = "Unauthorised or Invalid token request",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Resource not found",
                content = @Content) })
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @RequestBody Book book) {
        Book existingBook = bookService.findById(bookId);
        System.out.println("bookid:"+bookId);
        if (existingBook != null) {
            System.out.println("Exists");
            book.setId(bookId);
            bookService.update(book);
            return new ResponseEntity<>(bookService.save(book) , HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    @GetMapping("/books/{bookId}")
    @PreAuthorize("hasRole('MODERATOR')")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Results are ok", content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = BookRepository.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid request",
                content = @Content),
        @ApiResponse(responseCode = "401", description = "Unauthorised or Invalid token request",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Resource not found",
                content = @Content) })
    public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) {
        Book book = bookService.findById(bookId);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/books")
    @PreAuthorize("hasRole('MODERATOR')")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Results are ok", content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = BookRepository.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid request",
                content = @Content),
        @ApiResponse(responseCode = "401", description = "Unauthorised or Invalid token request",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Resource not found",
                content = @Content) })
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }


    @DeleteMapping("/books/delete/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Results are ok", content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = BookRepository.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid request",
                content = @Content),
        @ApiResponse(responseCode = "401", description = "Unauthorised or Invalid token request",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Resource not found",
                content = @Content) })
    public ResponseEntity<Void> deleteBook(@PathVariable Integer bookId) {
        Book existingBook = bookService.findById(bookId);
        if (existingBook != null) {
            bookService.delete(bookId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

