package edu.cnm.deepdive.model;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Encapsulates a list of {@link #cards} and {@link #dealt} cards.
 *
 * @author Vexur &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public class Deck {

  private List<Card> cards;
  private List<Card> dealt;

  /**
   * Pulls cards from the array list, and identifies their values depending on their {@link Suit} and {@link Rank}. It then stops when every card within the parameters of the corresponding suit and rank has been identified.
   */
  public Deck() {
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }
  }

  /**
   * Draws a {@link Card} and indexes through the contents within {@link #cards} and stops when {@link #cards} equals null.
   * @return Returns a card.
   */
  public Card deal() {

    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

  /**
   * Randomizes {@link #cards} and clears {@link #dealt} cards. It then takes the collected cards and shuffles them.
   * @param rng Randomizes the cards
   */
  public void shuffle(Random rng) {
    gather();
    Collections.shuffle(cards, rng);
  }

  private void gather() {
    cards.addAll(dealt);
    dealt.clear();
  }

  /**
   * Returns {@link #remaining()} {@link #cards} size.
   */
  public int remaining() {
    return cards.size();
  }

  /**
   * returns {@link #dealt()} cards within the {@link #cards} size.
   */
  public int dealt() {
    return  cards.size();
  }

 @Override
  public String toString() {
      return cards.toString();
  }

  public void sort(boolean gather) {
   if (gather) {
     gather();
   }
   cards.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank));
  }
  //time complexity
  //space complexity of merge sort
}
