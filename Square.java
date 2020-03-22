import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends JButton{
    private Color color;
    private Piece piece;
    private Font font;

    private int x;
    private int y;

    public Square(Color color, int x, int y){
        this.color = color;
        piece = null;

        this.x = x;
        this.y = y;

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

    public void changeColor(){
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

    public int x(){
        return x;
    }

    public int y(){
        return y;
    }
}