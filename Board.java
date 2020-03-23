
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
                if((i) % 2 != (j) % 2){
                    s = new Square(Color.BLACK, i, j);
                }
                else{
                    s = new Square(Color.RED, i, j);
                }

                board[i][j] = s;
                frame.add(s);
            }
        }

        //set up pieces
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].color() == Color.BLACK){
                    if(i != 3 && i != 4){
                        if(i < 3){
                            Piece p = new Piece(1, i, j);
                            board[i][j].addPiece(p);
                        }
                        else{
                            Piece p = new Piece(2, i, j);
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
                
                //int i = 1;
                //int x = 1;
                //int y = 2;
                //int j = 2;

                Integer pl = 0;
                boolean k = false;
                if(board[i][j].piece() != null){
                    pl = board[i][j].piece().player();
                    k = board[i][j].piece().isKing();
                }
                
                System.out.println(x + " " + y + " " + pl);
                System.out.println();

                ArrayList<Square> validSquares = new ArrayList<Square>();
                //top left
                if(x != 0 && y != 7 && (pl == 1 || k)){
                    validSquares.add(board[x - 1][y + 1]);
                }
                //top right
                if(x != 7 && y != 7 && (pl == 1 || k)){
                    validSquares.add(board[x + 1][y + 1]);
                }
                //bottom left
                if(x != 0 && y != 0 && (pl == 2 || k)){
                    validSquares.add(board[x - 1][y - 1]);
                }
                //bottom right
                if(x != 7 && y != 0 && (pl == 2 || k)){
                    validSquares.add(board[x + 1][y - 1]);
                }
                
                //removes squares with piece
                for(int m = 0; m < validSquares.size(); m++){
                    if(validSquares.get(m).piece() != null){
                        validSquares.remove(validSquares.get(m));
                    }
                }
                
                //System.out.println(x);
                //System.out.println(y);
                //System.out.println(pl);
                //System.out.println(k);
                //System.out.println(validSquares);

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