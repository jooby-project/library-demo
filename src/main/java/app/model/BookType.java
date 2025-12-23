package app.model;

/**
 * Defines the format and release schedule of the item.
 */
public enum BookType {
  /**
   * A fictional narrative story.
   * <p>
   * Examples: "Pride and Prejudice", "Harry Potter", "Dune".
   * These are creative works meant for entertainment or artistic expression.
   * </p>
   */
  NOVEL,

  /**
   * A written account of a real person's life.
   * <p>
   * Examples: "Steve Jobs" by Walter Isaacson, "The Diary of a Young Girl".
   * These are non-fiction historical records of an individual.
   * </p>
   */
  BIOGRAPHY,

  /**
   * An educational book used for study.
   * <p>
   * Examples: "Calculus: Early Transcendentals", "Introduction to Java Programming".
   * These are designed for students and are often used as reference material
   * in academic courses.
   * </p>
   */
  TEXTBOOK,

  /**
   * A periodical publication intended for general readers.
   * <p>
   * Examples: Time, National Geographic, Vogue.
   * These contain various articles, are published frequently (weekly/monthly),
   * and often have a glossy format.
   * </p>
   */
  MAGAZINE,

  /**
   * A scholarly or professional publication.
   * <p>
   * Examples: The New England Journal of Medicine, Harvard Law Review.
   * These focus on academic research or trade news and are written by experts
   * for other experts.
   * </p>
   */
  JOURNAL
}
