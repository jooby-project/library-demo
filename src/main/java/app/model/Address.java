package app.model;

import jakarta.persistence.Embeddable;

/**
 * A reusable way to store address details (Street, City, Zip).
 * We can reuse this on Authors, Publishers, or Users.
 */
@Embeddable
public class Address {
  /**
   * The specific street address.
   * <p>
   * Includes the house number, street name, and apartment number if applicable.
   * Example: "123 Maple Avenue, Apt 4B".
   * </p>
   */
  public String street;

  /**
   * The town, city, or municipality.
   * <p>
   * Used for grouping authors by location or calculating shipping regions.
   * </p>
   */
  public String city;

  /**
   * The postal or zip code.
   * <p>
   * Stored as text (String) rather than a number to support codes
   * that start with zero (e.g., "02138") or contain letters (e.g., "K1A 0B1").
   * </p>
   */
  public String zip;
}
