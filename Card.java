
public class Card {
       /** Store the value of rank (1 through 13). */
   private  int rank; 
   
   /** Store the value of suit (1 through 4) */
   private int suit; 
   
   /**
   * Initializes the Card to the specified rank and Suit.
   * @param rank the value of rank.
   * @param suit the value of suit.
   */
   
   public Card(int rank, int suit) {
      
      this.rank = rank;
      this.suit = suit;
      
      
      //invalid inputs 
      //if rank is less then 0 or greater then 13 set rank to 0
      if (rank < 0 || rank > 13) {
         this.rank = 0;
       
      }
      //if suit is less then 0 or greater then 4 set suit to 0
      if (suit < 0 || suit > 4) {
         this.suit = 0;
      }
   
   }
   
   /**
   *getter method for rank.
   *@return rank
   */
   
   public int getRank() {
      return this.rank;
   }
   
   /**
   *getter method for suit.
   *@return suit
   */
   
   public int getSuit() {
      return this.suit;
   }
    
   /**
   *getter method for String representation of suit.
   *@return suitStr
   */
   
   public String getTheSuit() {
    
      String suitStr;
      
      if (this.suit == 1) {
         suitStr = "Clubs";
      }
      else if (this.suit == 2) {
         suitStr = "Diamonds";
      }
      else if (this.suit == 3) {
         suitStr = "Hearts";
      }
      else if (this.suit == 4) {
         suitStr = "Spades";
      }
      else {
         this.suit = 0; 
         System.out.println("There is a suit that does not exist");
         return "";
      }
      
      return suitStr;

   }
   
   /**
   *determines if the rank is a special value. 
   * special values are:
   * 1 -- Ace 
   * 11 -- Jack
   * 12 -- Queen 
   * 13 -- King
   * @return boolean
   */
   
   public boolean rankIsSpecial() {
      
      //if the rank is any value that results in a ace king queen jack etc
      if (this.rank == 1 || this.rank == 11 || this.rank == 12 
          || this.rank == 13) {
         return true;
      } 
      return false;
   }
   
   /**
   * getter method for rank if it is a special value.
   * @return rankStr
   */
   
   public String getTheRank() {
      String rankStr;
      
      if (this.rank == 1) {
         rankStr = "Ace";
      }
      else if (this.rank == 11) {
         rankStr = "Jack";
      }
      else if (this.rank == 12) {
         rankStr = "Queen";
      }
      else if (this.rank == 13) {
         rankStr = "King";
      }
      else {
         this.rank = 0; 
         System.out.println("The rank does not exist");
         return "";
      }
      
      return rankStr;
      
   }
   
   /**
   * Overridden toString() method.
   * returns in the format of rank of suit
   * @return rankReturned + " of " + suitReturned
   */
   
   @Override
   public String toString() {
      
      if (this.rank == 0 || this.suit == 0) {
         System.out.println("This card does not exist");
         return "";
      }
       g
      String suitReturned;
      String rankReturned;
      
      suitReturned = getTheSuit();
      
      if (rankIsSpecial()) {
         rankReturned = getTheRank();
      }
      else {
         rankReturned = Integer.toString(this.rank);
      }
      
      return rankReturned + " of " + suitReturned;
      
   }
   
   /**
   * Overridden equals() method.
   * returns true if cards or equal and false otherwise
   * @return boolean
   */

   @Override
   public boolean equals(Object other) {
   
      Card cardCompared = (Card) other;
      
      if (this.rank == cardCompared.getRank() 
         && this.suit == cardCompared.getSuit()) {
         return true;
      }
      
      return false;
   }
   
   /** 
   * Compare this Card with the specified otherCard for order. 
   * @param otherCard the other Card object to be compared. 
   * @return a negative integer, zero, or a positive integer as 
   * this object is less than, equal to, or greater than the otherCard. 
   */ 
   
   public int compareTo(Card otherCard) { 
      
      int suitCompared = this.suit - otherCard.getSuit();
      
      //if the suits are equal then it comes down to the rank so do this 
      if (suitCompared == 0) {
         int rankCompared = this.rank - otherCard.getRank();
         return rankCompared;
      }
      
      //if the suits are not equal it skips the if statement 
      //and just returns based on suits 
      return suitCompared;
      
        
   }
}
