import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board{
    private JFrame frame;
    private GridLayout layout;

    private Square[][] board;

    public Board(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        layout = new GridLayout(8, 8);
        frame.setLayout(layout);

        //set up squares
        board = new Square[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Square s;
                if((i + 1) % 2 == (j + 1) % 2){
                    s = new Square(Color.BLACK);
                }
                else{
                    s = new Square(Color.RED);
                }

                board[i][j] = s;
                frame.add(s);
            }
        }

        //set up pieces
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].color() == Color.BLACK){
                    if(i + 1 != 4 && i + 1 != 5){
                        if(i + 1 < 4){
                            Piece p = new Piece(1, i + 1, j + 1);
                            board[i][j].addPiece(p);
                        }
                        else{
                            Piece p = new Piece(2, i + 1, j + 1);
                            board[i][j].addPiece(p);
                        }
                    }
                }
            }
        }
    }
}