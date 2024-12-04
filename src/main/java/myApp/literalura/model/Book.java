package myApp.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Author author;
    private String language;
    private Integer downloads;

    public Book() {}

    public Book(String title, Author newAuthor, String language, Integer downloads) {
        this.title = title;
        this.author = newAuthor;
        this.language = language;
        this.downloads = downloads;
    }

    public Book(String title, String language, Integer downloads) {
        this.title = title;
        this.language = language;
        this.downloads = downloads;
    }

    public Book(ResponseApi data) {
        this.title = data.bookData().get(0).title();
        this.author = new Author(data);
        this.language = data.bookData().get(0).languages().get(0);
        this.downloads = data.bookData().get(0).downloads();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return "---------- LIVRO ---------- \n" +
                "Nome: " + title + "\n" +
                "Autor: " + author.getName() + "\n" +
                "Idioma: " + language + "\n" +
                "Donwloads: " + downloads + "\n" +
                "---------------------------" + "\n";
    }
}
