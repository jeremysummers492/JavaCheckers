import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Piece{
    private Integer player;
    private String symbol;
    private Color color;
    private int x;
    private int y;
    private boolean king;

    public Piece(Integer player, int x, int y){
        this.player = player;
        this.x = x;
        this.y = y;

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

    public int x(){
        return x;
    }

    public int y(){
        return y;
    }

    public boolean isKing(){
        return king;
    }

    public String symbol(){
        return symbol;
    }
}