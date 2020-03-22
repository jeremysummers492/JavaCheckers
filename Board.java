import javax.swing.*;
import java.awt.*;

public class Board{
    private JFrame frame;
    private Square[][] board;
    
    public Board(){
        frame = new JFrame("Checkers");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        board = new Square[8][8];
    }
}