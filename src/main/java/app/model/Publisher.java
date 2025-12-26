package app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * A company that produces and sells books.
 */
@Entity
public class Publisher {
    /**
     * The unique internal ID for this publisher.
     * <p>
     * This is a number generated automatically by the system.
     * Users usually don't need to memorize this, but it's used by the database
     * to link books to their publishers.
     * </p>
     */
    @Id
    @GeneratedValue
    public Long id;

    /**
     * The official business name of the publishing house.
     * <p>
     * Example: "Penguin Random House" or "O'Reilly Media".
     * </p>
     */
    public String name;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }
}
