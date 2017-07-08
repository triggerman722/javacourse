package java9;

/**
 * Created by 1 on 07.10.2014.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JPanel
{
    ChessPiece selectedChessPiece = null;
    public ChessBoard(Dimension boardSize)
    {
        this.setLayout( new GridLayout(8, 8) );
        this.setPreferredSize( boardSize );
        this.setBounds(0, 0, boardSize.width, boardSize.height);

        boolean isBlack = true;
        for (int currentRow = 0; currentRow < 8; currentRow++) {
            for (int currentColumn=0; currentColumn < 8; currentColumn++) {
                final ChessSquare square = new ChessSquare(isBlack);
                this.add( square );
                square.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        ChessSquare square = (ChessSquare) e.getSource();
                        if (square.getComponentCount() > 0) {
                            selectedChessPiece = (ChessPiece) square.getComponent(0);
                            square.remove(0);
                        } else {
                            if (selectedChessPiece!=null) {
                                square.add(selectedChessPiece);
                                selectedChessPiece = null;
                            }
                        }
                        square.getParent().revalidate();
                        square.getParent().repaint();
                    }
                });
                isBlack=!isBlack;
            }
            isBlack=!isBlack;
        }

        // Add a few pieces to the board
        ChessPiece chessPiece = new ChessPiece();
        addChessPiece(chessPiece, 1);

        chessPiece = new ChessPiece();
        addChessPiece(chessPiece, 22);

        chessPiece = new ChessPiece();
        addChessPiece(chessPiece, 42);
    }

    public void addChessPiece(ChessPiece chessPiece, int location) {
        ChessSquare chessSquare = (ChessSquare)this.getComponent( location );
        chessSquare.add( chessPiece );
    }
}