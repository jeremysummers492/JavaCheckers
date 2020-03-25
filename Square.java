import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends JButton{
    private Color color;
    private Piece piece;
    private Font font;

    private int row;
    private int col;

    public Square(Color color, int row, int col){
        this.color = color;
        piece = null;

        this.row = row;
        this.col = col;

        font = new Font("Times", Font.BOLD, 40);

        setBackground(color);
        setFont(font);
    }

    public void addPiece(Piece p){
        piece = p;

        setLabel(p.symbol());
        setForeground(p.color());
    }

    public void removePiece(){
        piece = null;
    }

    public void highlight(){
        setBackground(Color.WHITE);
    }

    public void resetColor(){
        setBackground(color);
    }

    //return values
    public Color color(){
        return color;
    }

    public Piece piece(){
        return piece;
    }

    public int row(){
        return row;
    }

    public int col(){
        return col;
    }
}