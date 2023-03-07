package com.endava.blackjack;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Card {
    /**
     * This class is modelling a deck of cards
     */

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit; // this is the color/type
        this.rank = rank; // value of the card
    }

    public Card(String suit, String rank) {
        this.suit = Suit.valueOf(suit.toUpperCase());
        this.rank = Rank.valueOf(rank.toUpperCase());
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Card card1 = new Card(Suit.CLUBS, Rank.JACK);
        Card card2 = new Card(Suit.DIAMONDS, Rank.TEN);
        Card card3 = new Card("hearts", "queen");

        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        out.println(card1);
        out.println(card2);
        out.println(card3);
//        System.out.println(card1);
//        System.out.println(card2);


        // int total = card1.plus(card2);
        // Hand myHand = new Hand();
        // myHand.add(card1);
        // myHand.add(card2);
        // int total = myHand.getTotal();
    }

    public int getValue() {
        return this.rank.getValue();
    }

    @Override
    public String toString() {
        // JACK {Club Symbol}
        return this.rank.toString().concat(" ").concat(this.suit.toString());
    }
}
