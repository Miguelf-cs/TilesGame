/**
 * @author - Miguel Ferreiro 
 * COP-3337 Class Section U08
 * Instructor - Gregory Shaw
 * 
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
*/

import java.util.ArrayList ;
import java.util.Random;

/**
 * A NumberTile is a square tile with a number from 1 to 9 on each side
 */
public class NumberTile 
{
    private ArrayList<Integer> tile ;    // the 4-sided tile
    private static final Random gen = new Random() ;
      
    /**
       Create a NumberTile object with 4 random numbers in the range 1 to 9     
    */
    public NumberTile() 
    {
       tile = new ArrayList<Integer>() ; 
       
       //for each side of the number tile
       for ( int i = 0 ; i < 4 ; i++ )
       {
           tile.add(gen.nextInt( ( 9 - 1 + 1 ) + 1) ) ;   //add a random number
       }
    }
    
    /**
      Rotate this number tile 90 degrees      
    */
    public void rotate() 
    {    
        //temp value to store last value
        int temp = tile.remove(tile.size() - 1) ; 
        
        //add temp to first index and shift the other values 
        tile.add(0, temp) ;                
    }
    
    /**
     * Gets the left value of the number tile
     * @return left side value of number tile
     */
    public int getLeft()
    {
        return tile.get(0) ;
    }
    
    /**
     * Gets the right value of the number tile
     * @return right side value of number tile
     */
    public int getRight() 
    {
        return tile.get(2) ;
    }
    
    /**
     * Shows the four sided number tile
     * @return a number tile with 4 random values
     */
    public String toString() 
    {     
      String fullTile = "\n" + "  "     + tile.get(1)              + "\n" +
                           tile.get(0)  + "   "      + tile.get(2) + "\n" +
                            "  "        + tile.get(3)              + "\n" ;
      return fullTile ;   
    }    
} 
