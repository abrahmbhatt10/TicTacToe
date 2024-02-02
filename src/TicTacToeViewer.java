import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    public final int WINDOW_HEIGHT = 1800;
    public final int WINDOW_WIDTH = 1000;
    public final int TITLE_BAR_HEIGHT = 100;
    public final int BOX_SIZE = 200;
    public boolean isGameOver;
    public final int Y_OFFSET = (WINDOW_WIDTH - (BOX_SIZE*3)) / 2;
    public final int X_OFFSET = (WINDOW_HEIGHT - (BOX_SIZE*3)) / 2;
    private Square[][] board;
    private

    public TicTacToeViewer(Square[][] board) {
        board = new Square[board.length][board[1].length];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[1].length; j++)
            {
                this.board[i][j] = board[i][j];
            }
        }
        isGameOver = false;
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Square draw(Graphics g)
    {
        //fills in the rectangle with 4 lines
        g.drawRect(X_OFFSET, Y_OFFSET, BOX_SIZE, BOX_SIZE);

        //fills rectangle in green if won
        if(isGameOver)
        {
            for(int i = 0; i < board.length; i++)
            {
                for(int j = 0; j < board[0].length; j++)
                {
                    if(board[i][j].getIsWinningSquare())
                    {
                        g.setColor(Color.GREEN);
                        g.drawRect(board[i][j].getRow(), board[i][j].getCol(), BOX_SIZE, BOX_SIZE);
                        g.fillRect(board[i][j].getRow(), board[i][j].getCol(), BOX_SIZE, BOX_SIZE);
                    }
                }

            }

        }
    }

    public void paint(Graphics g)
    {
        //clears screen
        g.setColor(Color.WHITE);
        g.drawRect(0,0,WINDOW_HEIGHT,WINDOW_WIDTH);

    }
}
