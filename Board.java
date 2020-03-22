
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
                    s = new Square(Color.BLACK, i + 1, j + 1);
                }
                else{
                    s = new Square(Color.RED, i + 1, j + 1);
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
        
        setActionListeners();
    }

    public void setActionListeners(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                int x = board[i][j].x();
                int y = board[i][j].y();

                Integer pl = 0;
                boolean k = false;
                if(board[i][j].piece() != null){
                    pl = board[i][j].piece().player();
                    k = board[i][j].piece().isKing();
                }

                ArrayList<Square> validSquares = new ArrayList<Square>();
                if(x != 1 && y != 8 && (pl == 1 || k)){
                    validSquares.add(board[x - 2][y]);
                }
                if(x != 8 && y != 8 && (pl == 1 || k)){
                    validSquares.add(board[x][y]);
                }
                if(x != 1 && y != 1 && (pl == 2 || k)){
                    validSquares.add(board[x - 2][y - 2]);
                }
                if(x != 8 && y != 1 && (pl == 2 || k)){
                    validSquares.add(board[x][y - 2]);
                }

                for(int m = 0; m < validSquares.size(); m++){
                    if(validSquares.get(m).piece() != null){
                        validSquares.remove(validSquares.get(m));
                    }
                }

                board[i][j].addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            for(int i = 0; i < validSquares.size(); i++){
                                validSquares.get(i).changeColor();
                            }
                        }
                    });
            }
        }
    }

    //return values
    public Square[][] board(){
        return board;
    }
}