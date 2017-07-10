package java9;

import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Created by greg on 08/07/17.
 */
public class ChessPiece extends Label {

    ImageIcon a;

    public ChessPiece() {
        URL imgURL = ChessPiece.class.getResource("dukeWaveRed.gif");
        a = new ImageIcon(imgURL);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                final ChessPiece chessPiece = (ChessPiece)e.getSource();
                e.setSource(chessPiece.getParent());
                chessPiece.getParent().dispatchEvent(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(a.getImage(), 0, 0, this);
    }
}
