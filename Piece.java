import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Piece{
    private Integer player;
    private String symbol;
    private Color color;
    private int row;
    private int col;
    private boolean king;

    public Piece(Integer player, int row, int col){
        this.player = player;
        this.row = row;
        this.col = col;

        king = false;
        symbol = "O";

        if(player == 1){
            color = Color.RED;
        }
        else{
            color = Color.WHITE;
        }
    }

    public void becomeKing(){
        king = true;
        symbol = "8";
    }

    //return values
    public Integer player(){
        return player;
    }

    public Color color(){
        return color;
    }

    public int row(){
        return row;
    }

    public int col(){
        return col;
    }

    public boolean isKing(){
        return king;
    }

    public String symbol(){
        return symbol;
    }
}