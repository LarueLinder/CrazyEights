/*
 * @author Gateway Instructors
 * @version 1.0
 */

import java.util.Scanner;

/**
 * This class represents a human player (user) in a game of Crazy Eights.
 */
public class User extends Player {

   /** Message to print when prompting User to enter Card number. */
   public static final String SELECT_CARD_FROM_HAND_PROMPT =
      "Select a card from your hand or enter 0 to draw a new card:  ";

   /** Message to print when user selects a Card that is not playable. */
   public static final String CARD_DOES_NOT_MATCH_MESSAGE =
      "\n--- This card is not a match!\n\n";
      
   /** Message to print when user attempts to draw a Card, but is already
       holding a playable Card in their hand. */
   public static final String NO_DRAW_IF_HAVE_PLAYABLE_CARD_MESSAGE =
      "\n--- Hand contains playable card, so you may not draw " +
      "from draw pile!\n\n";

   /** Scanner used to read user's input. */
   private Scanner input;

   /** 
    * Create a new human player with the specified name and an empty hand.
    * @param theName the name of the human player
    * @param in the Scanner to use to collect input from the user
    */
   public User(String theName, Scanner in) {
      super(theName);
      input = in;
   }


   /**
    * Allow the user to make a move (take one turn). If user's hand
    * contains a playable card, they must select a card from their hand 
    * and "play" it to end their move. If no card currently in the user's
    * hand is playable, then they must draw from the drawpile until a
    * playable card is drawn, and "play" that one. Makes use of named
    * constants above to match expected message formatting.
    * @param crazyEight gives access to the "draw pile"
    * @param top the top of the "discard pile"
    * @return the card played by the user
    */
   public Card makeMove(Game crazyEight, Card top) {
      
   //print the message
      System.out.print(SELECT_CARD_FROM_HAND_PROMPT);
      int cardNum = input.nextInt();

      // loop until playable card selected
      while (true) {

         // If user selects a card number other than 0 - 0 would mean draw
         if (cardNum != 0) {

            //the card is 1 minus cus its in an array
            Card userCard = hand.getCard(cardNum - 1);

            // If card works return it
            if (Game.cardMatches(top, userCard)) {
               hand.discard(cardNum - 1);
               return userCard;
            } else {
               // tell user it does not match
               System.out.println(CARD_DOES_NOT_MATCH_MESSAGE);
               // Get next card choice from user
               System.out.print(SELECT_CARD_FROM_HAND_PROMPT);
               cardNum = input.nextInt();
            }
         } else {
            // this is if user picks 0
            //check if card is playable and prompt user to pick a new card
            //if they really dont have a playable card then run as usual
            if (hasPlayableCard(top)) {
               System.out.println(NO_DRAW_IF_HAVE_PLAYABLE_CARD_MESSAGE);
               System.out.print(SELECT_CARD_FROM_HAND_PROMPT);
               cardNum = input.nextInt();
            } else {
               // If user selects 0 and has no playable card then draw
               // until there is a match
               Card drawnCard = crazyEight.draw();
               hand.addCard(drawnCard);
               System.out.println("  " + name + " draws a " + drawnCard);
               if (Game.cardMatches(top, drawnCard)) {
                  hand.discard(hand.size() - 1);
                  return drawnCard;
               }
            }
         }
      }



   }

}
