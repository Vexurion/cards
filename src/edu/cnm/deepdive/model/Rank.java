package edu.cnm.deepdive.model;

import java.net.PortUnreachableException;

/**
 * Encapsulates all of the {@link Rank} values used in a standard deck of cards. {@code enum} also defines a {@link #symbol()} method that returns the 1- or 2-character shorthand abbreviation used in card play notation for each of its enumerated values.
 */
public enum Rank {

  ACE,
  TWO,
  THREE,
  FOUR,
  FIVE,
  SIX,
  SEVEN,
  EIGHT,
  NINE,
  TEN,
  JACK,
  QUEEN,
  KING;
  /**
   * Returns {@link #symbol()} values that correspond to their {@link Rank} enumerated values.
   */
  private static final  String[] symbols = {
      "A",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9",
      "10",
      "J",
      "Q",
      "K"
  };

  /**
   * Returns Unicode playing card symbol for this suit.
   * @return Unicode Symbol
   */
  public final String symbol() {
    return symbols[ordinal()];
  }
}
