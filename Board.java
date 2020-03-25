
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Board{
    private JFrame frame;
    private GridLayout layout;

    private Square[][] board;
    
    private Square start;
    private Square end;

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
                            Piece p = new Piece(2, i, j);
                            board[i][j].addPiece(p);
                        }
                        else{
                            Piece p = new Piece(1, i, j);
                            board[i][j].addPiece(p);
                        }
                    }
                }
            }
        }

        setActionListeners();
    }

    public ArrayList<Square> availableMoves(Square s){
        ArrayList<Square> moves = new ArrayList<Square>();

        if(s.piece() != null){
            Piece p = s.piece();
            int pl = p.player();
            boolean k = p.isKing();

            int row = s.row();
            int col = s.col();

            if(pl == 1 || k){
                //top left
                if(row != 0 && col != 0){
                    Square m = board[row - 1][col - 1];

                    if(m.piece() == null){
                        moves.add(m);
                    }
                }

                //top right
                if(row != 0 && col != 7){
                    Square m = board[row - 1][col + 1];

                    if(m.piece() == null){
                        moves.add(m);
                    }
                }
            }
            if(pl == 2 || k){
                //bottom left
                if(row != 7 && col != 0){
                    Square m = board[row + 1][col - 1];

                    if(m.piece() == null){
                        moves.add(m);
                    }
                }

                //bottom right
                if(row != 7 && col != 7){
                    Square m = board[row + 1][col + 1];

                    if(m.piece() == null){
                        moves.add(m);
                    }
                }
            }
        }

        return moves;
    }

    public void setActionListeners(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                int r = i;
                int c = j;

                board[i][j].addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            if(board[r][c].color() == Color.BLACK){
                                
                                resetColors();
                                
                                start = board[r][c];
                                
                                ArrayList<Square> availableMoves = availableMoves(board[r][c]);

                                for(int k = 0; k < availableMoves.size(); k++){
                                    availableMoves.get(k).highlight();
                                }
                            }
                            else if(board[r][c].color() == Color.WHITE){
                                board[r][c].addPiece(start.piece());
                                start.removePiece();
                            }
                        }
                    });
            }
        }
    }
    
    public void resetColors(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j].resetColor();
            }
        }
    }
    
    //return values
    public Square[][] board(){
        return board;
    }
}