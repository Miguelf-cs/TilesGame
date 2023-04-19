/**
 * @author - Miguel Ferreiro 
 * COP-3337 Class Section U08
 * Instructor - Gregory Shaw
 * 
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
*/

import java.util.Scanner;

/**
 * A test class for the NumberTile Game
*/
public class TileGameTester
{
   public static void main(String[] args)
   {
       int replay = 1 ;
       
       while( replay == 1 ) // while user keeps inputting 1 then starts new game
       {
           System.out.println("Starting a new game... ");
           
           // create two Hand objects 
           Hand player1 = new Hand() ;
           Hand player2 = new Hand() ;
           
           // create TileGame object
           TileGame newGame = new TileGame(player1, player2) ;
           
           // display both players initial hands
           System.out.println("***** PLAYER 1 INITIAL HAND *****") ;
           System.out.println(player1) ;
           System.out.println("***** PLAYER 2 INITIAL HAND *****") ;
           System.out.println(player2) ;
           
           // start a new game
           newGame.play() ;
           
           // print the winner of the new game
           System.out.println(newGame.getResults()) ; 
           
           System.out.println("Would you like to play again?");
           System.out.println("(1 for YES or any other number for NO)" + "\n");
           Scanner answer = new Scanner(System.in) ;
           
           replay = answer.nextInt() ;
       }
       
   }
} 
