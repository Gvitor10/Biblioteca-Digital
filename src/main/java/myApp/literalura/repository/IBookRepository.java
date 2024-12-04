package myApp.literalura.repository;

import myApp.literalura.model.Author;
import myApp.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IBookRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByNameContainingIgnoreCase(String authorName);

    @Query("SELECT b FROM Book b")
    List<Book> findAllBooks();

    @Query("SELECT a FROM Author a")
    List<Author> findAllAuthors();

    @Query("SELECT b FROM Book b WHERE b.language ILIKE %:language%")
    List<Book> findBookByLanguage(String language);

    @Query("SELECT a FROM Author a WHERE a.birthYear <= %:year% AND a.deathYear IS NULL OR a.deathYear > %:year% ")
    List<Author> findAuthorsByYear(Integer year);
}
