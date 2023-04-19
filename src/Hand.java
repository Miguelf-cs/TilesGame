/**
 * @author - Miguel Ferreiro 
 * COP-3337 Class Section U08
 * Instructor - Gregory Shaw
 * 
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
*/

import java.util.ArrayList;

/**
 * A players hand with number tiles being held
 */
public class Hand
{
    private ArrayList<NumberTile> hand ;
    private final static int INITIAL_SIZE = 5 ;  // starting hand size
    
    /**
     * Creates a new hand of INITIAL_SIZE NumberTiles
     */ 
    public Hand()
    {
       hand = new ArrayList<NumberTile>() ;
       
       // for every slot in the empty hand
       for ( int i = 0 ; i < INITIAL_SIZE ; i++ )
       {
           hand.add(new NumberTile()) ; // add a new number tile
       }
    }
       
    /**
     * Get the NumberTile at the specified index in this Hand
     * @param index of current tile you want to get
     * @return the tile in the current index
     */
    public NumberTile get(int index)
    {
       return hand.get(index) ;
    }
    
    /**
     * Get the number of tiles in this Hand
     * @return the total number of tiles in the hand
     */
    public int getSize()
    {
       return hand.size();   // calls "size" method of ArrayList class
    }
    
    /**
     * Add a new NumberTile to this Hand
     */
    public void addTile()
    {
       hand.add(new NumberTile()) ;   // calls "add" method of ArrayList class
    }
    
    /**
     * Remove the NumberTile at the specified index from this Hand
     * @param index of tile you want to remove
     */
    public void removeTile(int index)
    {
        hand.remove(index) ;
    }
    
    /**
     * Determine whether the hand is empty or not
     * @return the hand if it has number tiles or not
     */
    public boolean isEmpty()
    {
       return hand.isEmpty() ;   // calls "isEmpty" method of ArrayList class
    }
    
    /**
     * Shows the hand and its number tiles
     * If this Hand is empty, return an appropriate message
     * @return all the number tiles in the hand
     */
    public String toString()
    {
        String getHand = " ";
        if ( hand.isEmpty() )
        {
           return "The hand is empty" ;
        }else
        {
           for ( int i = 0 ; i < hand.size() ; i++ )
           {
               getHand += hand.get(i).toString() ;
           }
        }
           return getHand ;
    }       
}
