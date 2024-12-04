package myApp.literalura.principal;

import myApp.literalura.model.Author;
import myApp.literalura.model.BigTitle;
import myApp.literalura.model.Book;
import myApp.literalura.model.ResponseApi;
import myApp.literalura.repository.IBookRepository;
import myApp.literalura.service.CleanTerminal;
import myApp.literalura.service.ConsumeAPI;
import myApp.literalura.service.ConvertData;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final Scanner KEYBOARD = new Scanner(System.in);
    private final String URL = "https://gutendex.com/books/?search=";
    private final ConsumeAPI API = new ConsumeAPI();
    private final ConvertData CONVERTER = new ConvertData();
    private final IBookRepository REPOSITORY;

    public Principal(IBookRepository repository) {
        this.REPOSITORY = repository;
    }

    public void showMenu() {
        int option = -1;
        String menu = """
                        ------------------------------
                       \s
                        1. Buscar livro pelo título.
                        2. Listar livros registrados.
                        3. Listar autores registrados.
                        4. Listar autores vivos em determinado ano.
                        5. Listar livros em um determinado idioma.
                       \s
                        ------------------------------
                       \s
                        0 - Pressione 0 para encerrar a aplicação.
                   \s""";

        while (option != 0) {
            CleanTerminal.clean();
            BigTitle.showBigTitle();
            System.out.println(menu);
            option = KEYBOARD.nextInt();
            KEYBOARD.nextLine();

            switch (option) {
                case 1:
                    CleanTerminal.clean();
                    findBookByTitle();
                    KEYBOARD.nextLine();
                    break;
                case 2:
                    CleanTerminal.clean();
                    showAllRegisteredBooks();
                    KEYBOARD.nextLine();
                    break;
                case 3:
                    CleanTerminal.clean();
                    showAllRegisteredAuthors();
                    KEYBOARD.nextLine();
                    break;
                case 4:
                    CleanTerminal.clean();
                    findAuthorsByYear();
                    break;
                case 5:
                    CleanTerminal.clean();
                    booksByLanguage();
                    break;
                case 0:
                    CleanTerminal.clean();
                    System.out.println("""
                    ------------------------------
                    Encerrando a aplicação...
                    Até mais :).
                    ------------------------------
                """);
                    break;
                default:
                    CleanTerminal.clean();
                    System.out.println("""
                    ------------------------------
                    Opção inválida :( ...
                    Tente novamente!.
                    ------------------------------
                """);
            }
        }
    }
    // Methods here...
    private void findBookByTitle() {
        System.out.println("Digite o nome do livro que deseja buscar:");
        String bookName = KEYBOARD.nextLine();
        String json = API.getData(URL + bookName.replace(" ", "%20").toLowerCase());
        ResponseApi data = CONVERTER.getData(json, ResponseApi.class);
        Book foundBook = new Book(data);

        Optional<Author> author = REPOSITORY.findByNameContainingIgnoreCase(data.bookData().get(0).authors().get(0).name());
        if (author.isPresent()) {
            if (author.get().getBooks().stream().anyMatch(b -> bookName.toLowerCase().equals(b.getTitle().toLowerCase()))) {
                System.out.println("Livro já cadastrado no banco de dados :)... \n");
            }
            else {
                System.out.println("Livro não casdastrado...Buscando na API :)... \n");
                Book newBook = new Book(data);
                author.get().getBooks().add(newBook);
                newBook.setAuthor(author.get());

                REPOSITORY.save(author.get());
            }
        } else {
            // Register new author
            System.out.println("Livro e autor não casdastrado...Buscando na API :)... \n");
            Author newAuthor = new Author(data);
            newAuthor.setBooks(data.bookData().stream()
                    .map(dta -> new Book(dta.title(), newAuthor, dta.languages().get(0), dta.downloads()))
                    .collect(Collectors.toList()));

            REPOSITORY.save(newAuthor);
        }

        System.out.println(foundBook.toString());
    }

    private void showAllRegisteredBooks() {
        List<Book> books = REPOSITORY.findAllBooks();
        books.forEach(b -> System.out.println(b.toString()));
    }

    private void showAllRegisteredAuthors() {
        List<Author> authors = REPOSITORY.findAllAuthors();
        authors.forEach(a -> System.out.println(a.toString()));
    }

    private void booksByLanguage() {
        System.out.println("""
                            Digite o idioma desejado:
                            
                            Es - espanhol
                            Fr - francês
                            En - inglês
                            Pt - português
                            """);
        String option = KEYBOARD.nextLine();

        List<Book> books = REPOSITORY.findBookByLanguage(option.toLowerCase());

        if (books.isEmpty()) {
            System.out.println("Nenhum livro com o idioma desejado foi encontrado :(");
        } else {
            books.forEach(b -> System.out.println(b.toString()));
        }
    }

    private void findAuthorsByYear() {
        System.out.println("Insira o ano que deseja buscar:");
        Integer year = KEYBOARD.nextInt();

        List<Author> authors = REPOSITORY.findAuthorsByYear(year);

        if (authors.isEmpty()) {
            System.out.println("Nenhum autor com o ano desejado foi encontrado :(");
        } else {
            authors.forEach(b -> System.out.println(b.toString()));
        }
    }
}
