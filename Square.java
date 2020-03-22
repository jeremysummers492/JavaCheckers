import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends JButton implements ActionListener{
    private Color color;
    private boolean hasPiece;
    private Font font;

    public Square(Color color){
        this.color = color;
        hasPiece = false;

        font = new Font("Times", Font.BOLD, 40);

        setBackground(color);
        setFont(font);
    }

    public void addPiece(Piece p){
        hasPiece = true;

        setLabel(p.symbol());
        setForeground(p.color());
    }

    public void removePiece(){
        hasPiece = false;
    }

    //return values
    public Color color(){
        return color;
    }

    public boolean hasPiece(){
        return hasPiece;
    }

    //ActionListener
    public void actionPerformed(ActionEvent e){
    }
}