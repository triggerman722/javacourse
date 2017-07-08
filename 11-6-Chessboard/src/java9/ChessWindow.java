package java9;

import javax.swing.*;
import java.awt.*;

/**
 * Created by greg on 08/07/17.
 */
public class ChessWindow extends JFrame {

    private JLayeredPane layeredPane;

    public void start() {
        Dimension boardSize = new Dimension(600, 600);
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize( boardSize );

        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.pack();
        this.setResizable( false );
        this.setLocationRelativeTo( null );

        ChessBoard chessBoard = new ChessBoard(boardSize);
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);

        this.setVisible(true);

    }

    public static void main(String[] args)
    {
        ChessWindow chessWindow = new ChessWindow();
        chessWindow.start();
    }
}
