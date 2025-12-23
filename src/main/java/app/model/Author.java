package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

/**
 * A person who writes books.
 */
@Entity
public class Author {

  /**
   * The author's unique government ID (SSN).
   */
  @Id
  public String ssn;

  /**
   * The full name of the author.
   */
  public String name;

  /**
   * Where the author lives.
   * This information is stored inside the Author table, not a separate one.
   */
  @Embedded
  public Address address;

  @ManyToMany
  @JsonIgnore
  public Set<Book> books = new HashSet<>();

  public Author() {}

  public Author(String ssn, String name) {
    this.ssn = ssn;
    this.name = name;
  }
}

