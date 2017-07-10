package java9;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by greg on 08/07/17.
 */
public class ChessWindow extends Frame {

    public void start() {

        Dimension boardSize = new Dimension(600,600);
        this.setSize(boardSize);

        ChessBoard chessBoard = new ChessBoard(boardSize);
        this.add(chessBoard);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args)
    {
        ChessWindow chessWindow = new ChessWindow();
        chessWindow.start();
    }

}
