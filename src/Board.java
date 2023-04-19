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
 * This board is where tiles will be placed for the NumberTile game  
 */
public class Board
{
    private ArrayList<NumberTile> board ;   // the board for a NumberTile game
    
    /**
     * Creates a new Board containing a single NumberTile
     */
    public Board()
    {
       board = new ArrayList<NumberTile>() ;
       board.add(new NumberTile()) ;
    }
    
    /**
     * Return the NumberTile at the specified index on this Board
     * @param index of number tile on the board
     * @return specified number tile on the board
     */
    public NumberTile getTile (int index)
    {
       return board.get(index) ;
    }
    
    /**
     * Return the current number of tiles on this Board
     * @return the total number of tiles on the board
     */
    public int getSize()
    {
       return board.size() ;
    }
    
    /**
     * Insert a new tile into this Board at the specified index
     * @param index of where new tile should be inserted
     * @param tile that should be inserted onto the board
     */
    public void addTile(int index, NumberTile tile)
    {
       board.add(index, tile) ;
    }
    
    /**
     * Return a multiline string containing all the tiles on this Board
     * @return the hand's current number tiles
     */
    public String toString()
    {
       String theBoard = "";
       for ( int i = 0 ; i < board.size() ; i++ )
       {
           theBoard += board.get(i).toString();
       }
       return theBoard ;
    }           
}