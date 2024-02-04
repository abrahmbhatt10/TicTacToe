import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    public final int BOX_SIZE = 200;
    public final int WINDOW_HEIGHT = 5 * BOX_SIZE;
    public final int WINDOW_WIDTH = 5 * BOX_SIZE;
    public final int TITLE_BAR_HEIGHT = 50;
    public boolean isGameOver;
    public final int Y_OFFSET = BOX_SIZE;
    public final int X_OFFSET = BOX_SIZE;
    public Image markerImageX, scaledImageX;
    public Image markerImageO, scaledImageO;
    private TicTacToe backEnd;

    public TicTacToeViewer(TicTacToe backEnd) {
        this.backEnd = backEnd;
        isGameOver = false;
        this.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        try {
            markerImageX = ImageIO.read(new File("Resources/X.png"));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        try {
            markerImageO = ImageIO.read(new File("Resources/O.png"));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        scaledImageX = markerImageX.getScaledInstance(BOX_SIZE, BOX_SIZE, 0);
        scaledImageO = markerImageO.getScaledInstance(BOX_SIZE, BOX_SIZE, 0);
    }

    public int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    public int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    public int getTITLE_BAR_HEIGHT() {
        return TITLE_BAR_HEIGHT;
    }

    public int getSquareLength() {
        return BOX_SIZE;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public int getY_OFFSET() {
        return Y_OFFSET;
    }

    public int getX_OFFSET() {
        return X_OFFSET;
    }

    //paints squares
    public void paint(Graphics g)
    {
        //clears screen
        g.setColor(Color.WHITE);
        g.drawRect(0,0,WINDOW_HEIGHT,WINDOW_WIDTH);
        g.fillRect(0,0,WINDOW_HEIGHT,WINDOW_WIDTH);
        for(int i = 0; i < backEnd.getBoard().length; i++)
        {
            g.setColor(Color.WHITE);
            g.drawRect(BOX_SIZE,BOX_SIZE * i,BOX_SIZE, BOX_SIZE);
            g.setColor(Color.RED);
            Font stringFont = new Font("Times New Roman", Font.PLAIN, 24);
            g.setFont(stringFont);
            g.drawString(Integer.toString(i), (int) (0.5 * BOX_SIZE), (int) (BOX_SIZE * (i + 1) + 0.5 * BOX_SIZE));
        }
        for(int i = 0; i < backEnd.getBoard()[0].length; i++)
        {
            g.setColor(Color.WHITE);
            g.drawRect(i * BOX_SIZE,BOX_SIZE,BOX_SIZE,BOX_SIZE);
            g.setColor(Color.RED);
            Font stringFont = new Font("Times New Roman", Font.PLAIN, 24);
            g.setFont(stringFont);
            g.drawString(Integer.toString(i), (int) ((i + 1) * BOX_SIZE + 0.5 * BOX_SIZE), (int) (0.5 * BOX_SIZE));
        }
        g.setColor(Color.BLACK);
        for(int i = 0; i < backEnd.getBoard().length; i++)
        {
            for(int j = 0; j < backEnd.getBoard()[0].length; j++)
            {
                backEnd.getBoard()[i][j].draw(g);
            }
        }
        if(backEnd.isGameOver)
        {
            if(!backEnd.checkWin()) {
                g.setColor(Color.WHITE);
                g.drawRect(BOX_SIZE,4 * BOX_SIZE,5 * BOX_SIZE,BOX_SIZE);
                g.setColor(Color.BLACK);
                Font stringFont = new Font("Times New Roman", Font.BOLD, 48);
                g.setFont(stringFont);
                g.drawString(" Game ends in a tie!", BOX_SIZE, (int) (4 * BOX_SIZE + 0.5 * BOX_SIZE));
            } else {
                if (backEnd.turn % 2 == 0) {
                    g.setColor(Color.WHITE);
                    g.drawRect(BOX_SIZE,4 * BOX_SIZE,5 * BOX_SIZE,BOX_SIZE);
                    g.setColor(Color.BLACK);
                    Font stringFont = new Font("Times New Roman", Font.BOLD, 48);
                    g.setFont(stringFont);
                    g.drawString("   O Wins!", BOX_SIZE, (int) (4 * BOX_SIZE + 0.5 * BOX_SIZE));
                } else {
                    g.setColor(Color.WHITE);
                    g.drawRect(BOX_SIZE,4 * BOX_SIZE,5 * BOX_SIZE,BOX_SIZE);
                    g.setColor(Color.BLACK);
                    Font stringFont = new Font("Times New Roman", Font.BOLD, 48);
                    g.setFont(stringFont);
                    g.drawString("   X Wins!", BOX_SIZE, (int) (4 * BOX_SIZE + 0.5 * BOX_SIZE));
                }
            }
        }
    }
}
