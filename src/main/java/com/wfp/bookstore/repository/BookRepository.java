package  com.wfp.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfp.bookstore.entity.*;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
}