package edu.cnm.deepdive.controller;

import edu.cnm.deepdive.model.Card;
import edu.cnm.deepdive.model.Deck;
import edu.cnm.deepdive.model.Suit.Color;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Calls {@link Deck}, assigns a list to {@link #redPile} and {@link #blackPile}, and assigns {@link #rng} to SecureRandom.
 */
public class Trick {

  private Deck deck;
  private List<Card> redPile;
  private List<Card> blackPile;
  private Random rng = new SecureRandom();

  /**
   * Calls for {@link Trick} methods within this class such as {@link #prepare()}, {@link #split()}, {@link #swap()}, and {@link #report()}.
   * @param args
   */
  public static void main(String[] args) {
    Trick trick = new Trick();
    trick.prepare();
    trick.split();
    trick.swap();
    trick.report();
  }

  /**
   * Prepares the {@link #deck} and shuffles it randomly.
   */
  private void prepare() {
    deck = new Deck();
    deck.shuffle(rng);
  }

  /**
   * Splits {@link #redPile} and {@link #blackPile} into linked lists and loops through each card to assign cards to the corresponding colors.
   */
  private void split() {
    redPile = new LinkedList<>();
    blackPile = new LinkedList<>();
    for (Card selector = deck.deal(); selector != null; selector = deck.deal()) {
      if (selector.getSuit().color() == Color.BLACK) {
        blackPile.add(deck.deal());
      } else {
        redPile.add(deck.deal());
      }
    }
  }

  /**
   * Swaps {@link #redPile} and {@link #blackPile}, and removes black and red cards from their opposing pile colors.
   */
  private void swap() {
    int swapSize = rng.nextInt(1 + Math.min(blackPile.size(), redPile.size()));
    for (int i = 0; i < swapSize; i++) {
      redPile.add(blackPile.remove(0));
      blackPile.add(redPile.remove(0));
    }
  }

  /**
   * Reports the value of the red and black piles.
   */
  private void report() {
    int redCount = 0;
    int blackCount = 0;
    for (Card c : redPile) {
      if (c.getSuit().color() == Color.RED) {
        redCount++;
      }
    }
    for (Card c : blackPile) {
      if (c.getSuit().color() == Color.BLACK) {
        blackCount++;
      }
    }
    System.out.printf("Red Pile: %s. Red count: %d.%n", redPile, redCount);
    System.out.printf("Black Pile: %s. Black count: %d.%n", blackPile, blackCount);
  }

}



