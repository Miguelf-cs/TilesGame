/**
 * @author - Miguel Ferreiro 
 * COP-3337 Class Section U08
 * Instructor - Gregory Shaw
 * 
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
*/

// Implements a domino-like game where two players, both of whom are
// the computer, take turns inserting NumberTiles into a Board
public class TileGame
{
   // instance vars
   private Board board ;     // the game board
   private Hand hand1 ;      // Player 1 hand
   private Hand hand2 ;      // Player 2 hand
   private String winner ;   // the winner - player1, player2,
                             // or a tie game
   
   /**
    * Creates a new TileGame with two initial hands and a board
    * @param firstHand of the first player
    * @param secondHand of the second player
    */
   public TileGame(Hand firstHand, Hand secondHand)
   {
      hand1 = firstHand ;
      hand2 = secondHand ;
      board = new Board() ;
   }
   
   /**
    * Players take turn moving until one or both hand are empty
    */
   public void play()
   {
      while ( hand1.getSize() > 0 && hand2.getSize() > 0 )
      {
          makeMove(hand1) ;
          makeMove(hand2) ;
          
          if ( hand1.getSize() == 0 && hand2.getSize() == 0 )
          {
               winner = "===== THE GAME IS TIED =====" ;
          }else if ( hand1.getSize() == 0 )
          {
               winner = "===== PLAYER 1 IS THE WINNER =====" ;
          }else if ( hand2.getSize() == 0 )
          {
               winner = "===== PLAYER 2 IS THE WINNER =====" ;
          }else
          {
               winner = "Error" ;
          }
      }
   }

   
   // Returns the index at which a new tile will be inserted into the board,
   // or -1 if the tile cannot be inserted.  The new tile may be inserted 
   // either (1) between two  existing tiles, (2) as the new first tile, or 
   // (3) as the new last tile   
   private int getIndexForFit(NumberTile tile)
   {
       if ( board.getSize() == 0 || tile.getRight() == board.getTile(0).getLeft())
       {
           return 0;
       }
       if ( tile.getLeft() == board.getTile(board.getSize() - 1).getRight() )
       {
           return board.getSize();
       }
      for ( int i = 1 ; i < board.getSize() ; i++ )
      {
           if ( board.getTile(i - 1).getRight() == tile.getLeft() &&
                board.getTile(i).getLeft() == tile.getRight() ) 
           {
               return i;
           }
      }
       return -1 ;
   }

   // Checks consecutive tiles in the hand - by calling method getIndexForFit()
   // to see if one can be inserted into the board. When the first tile that 
   // fits is found, removes it from the hand, inserts it into the board, and 
   // the move ends. The tile may be rotated up to 3 times. If none of the tiles
   // fit, adds a new, random tile to the hand   
   private void makeMove(Hand hand)
   {
       // for each number tile in the hand
       for ( int i = 0 ; i < hand.getSize() ; i++) 
       {
           // get the current number tile
           NumberTile tile = hand.get(i) ;
           
           // get the index of where the tile could be placed
           int boardIndex = getIndexForFit(tile) ;
           
           // counter to rotate the tile up to three times
           int rotateTile = 0 ;
           while( rotateTile <= 3 ) 
           {
               if ( boardIndex != -1 ) 
               {
                   board.addTile(boardIndex, tile) ;
                   hand.removeTile(i) ;
                   return ;
               }   
               tile.rotate() ;
               boardIndex = getIndexForFit(tile) ;
               rotateTile++ ;
           }
       }
       hand.addTile();   // adds tile to hand if no tiles cannot be placed
   }
  
   /**
    * Return results of the game as a humongous multi-line String containing 
    * the final board, both both player's final hands, and the winner
    * @return results of the game and declares the winner
    */
   public String getResults()
   {
     return     "\n\n***** The Final Board *****\n" + board.toString()
                + "\n\n***** Player 1's Final Hand *****\n" + hand1.toString()
                + "\n\n***** Player 2's Final Hand *****\n" + hand2.toString()+
                "\n\n" + winner;
   }
} 