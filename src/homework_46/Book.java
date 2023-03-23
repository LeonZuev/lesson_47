package homework_46;

import java.util.Objects;

public class Book implements Comparable<Book> {

  private final String title;
  private final String author;
  private final int pages;

  public Book(String title, String author, int pages) {
    this.title = title;
    this.author = author;
    if (pages < 0) {
      throw new IllegalArgumentException("Negative pages: " + pages);
    }
    this.pages = pages;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getPages() {
    return pages;
  }

  // "натуральная сортировка" - автор, потом название
  @Override
  public int compareTo(Book o) {
    if (!author.equals(o.author)) {
      return author.compareTo(o.author);
    }
    if (!title.equals(o.title)) {
      return title.compareTo(o.title);
    }
    return pages - o.pages; // добавили сравнение страниц для совпадения с equals и hashCode
    // обычно hashCode использует все поля.
    // в генераторе hashCode и equals можно выбрать, какие поля использовать
    // ВАЖНО:
    // - используемые в equals и hashCode поля должны учитываться в compareTo
    // - compareTo() == 0 и equals() == true должны быть совпадающими условиями
    // если эти пункты не выполняются, в программе возможны неожиданные баги -
    // ошибки, которые очень сложно будет найти
  }

  // если определили compareTo, значит, определили и "что такое равенство"
  // значит, надо переопределить equals()
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Book other)) {
      return false;
    }
    // дальше мы сравниваем Book this и Book other
    return /*this.*/compareTo(other) == 0; // если compareTo вернул 0, то книги равны
  }

  // В идеальном мире все поля одновременно учитываются и в hashCode, и в equals, и в compareTo
  // НИ ОДИН из этих трёх методов никак не связан с компаратором
  @Override
  public int hashCode() {
    return Objects.hash(author, title, pages);
  }

  @Override
  public String toString() {
    return "Book{title='" + title + "', author='" + author + "', pages=" + pages + "}";
  }
}