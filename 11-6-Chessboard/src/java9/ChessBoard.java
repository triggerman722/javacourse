package java9;

/**
 * Created by 1 on 07.10.2014.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class ChessBoard extends JFrame implements MouseListener, MouseMotionListener
{
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;

    public ChessBoard()
    {
        Dimension boardSize = new Dimension(600, 600);

        //  Use a Layered Pane for this this application

        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize( boardSize );
        layeredPane.addMouseListener( this );
        layeredPane.addMouseMotionListener( this );

        //  Add a chess board to the Layered Pane

        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( boardSize );
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++)
        {
            JPanel square = new JPanel( new BorderLayout() );
            chessBoard.add( square );

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground( i % 2 == 0 ? Color.black : Color.white );
            else
                square.setBackground( i % 2 == 0 ? Color.white : Color.black );
        }

        // Add a few pieces to the board

        JLabel piece = new JLabel( new ImageIcon("dukewavered.gif") );
        JPanel panel = (JPanel)chessBoard.getComponent( 0 );
        panel.add( piece );
        piece = new JLabel( new ImageIcon("dukewavered.gif") );

        panel = (JPanel)chessBoard.getComponent( 16 );
        panel.add( piece );
    }




    public void mouseClicked(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args)
    {
        JFrame frame = new ChessBoard() {
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }
        };
        frame.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        frame.pack();
        frame.setResizable( false );
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}
