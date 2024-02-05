import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private TicTacToe backEnd;
    public boolean isWinningSquare() {
        return isWinningSquare;
    }

    public TicTacToe getBackEnd() {
        return backEnd;
    }

    public void setBackEnd(TicTacToe backEnd) {
        this.backEnd = backEnd;
    }

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setWinningSquare(boolean winningSquare) {
        isWinningSquare = winningSquare;
    }

    /**
     * @return the marker for the square
     */



    public String toString() {
        return this.marker;
    }


    public boolean getIsWinningSquare() {
        return isWinningSquare;
    }

    public void draw(Graphics g)
    {
        //fills in the rectangle with 4 lines
        int xOffset = backEnd.getxOffset();
        int yOffset = backEnd.getyOffset();
        int length = backEnd.getsLength();

        g.drawRect(xOffset+col*length, yOffset+ row*length, length, length);

        //fills rectangle in green if won
        if(getIsWinningSquare())
        {   g.setColor(Color.GREEN);
            g.fillRect(xOffset+col*length, yOffset+row*length, length, length);
        }

        if(marker.equals(backEnd.X_MARKER))
        {
            g.drawRect( xOffset+col*length,yOffset+row*length, length, length);
            g.drawImage(backEnd.getxMarkerImage(), xOffset + col * length, yOffset + row * length,null);
        }
        if(marker.equals(backEnd.O_MARKER))
        {
            g.drawRect( xOffset+col*length, yOffset+row*length, length, length);
            g.drawImage(backEnd.getoMarkerImage(),  xOffset + col * length, yOffset + row * length,null);
        }
    }

}


