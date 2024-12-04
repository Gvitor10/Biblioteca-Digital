package myApp.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author(){}

    public Author(ResponseApi responseApi) {
        this.name = responseApi.bookData().get(0).authors().get(0).name();
        this.birthYear = responseApi.bookData().get(0).authors().get(0).birthYear();
        this.deathYear = responseApi.bookData().get(0).authors().get(0).deathYear();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "---------- AUTOR ---------- \n" +
                "Nome: " + name + "\n" +
                "Ano de Nascimento: " + birthYear + "\n" +
                "Ano de Falecimento: " + deathYear + "\n" +
                "---------------------------" + "\n";
    }
}
