package homework_46;

import java.util.ArrayList;
import java.util.List;

public class BooksRunner {
  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Букварь", "Неизвестно",125));
    books.add(new Book("Букварь", "Народ",25));
    books.add(new Book("АИ", "Иа",5));

    books.sort(new BookTitleAuthorComparator());
    for (Book b: books) {
      System.out.println(b);
    }
  }
}
