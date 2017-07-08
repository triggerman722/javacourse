package java9;

import javax.swing.*;
import java.awt.*;

/**
 * Created by greg on 08/07/17.
 */
public class ChessPiece extends JLabel {

    public ChessPiece() {
        java.net.URL imgURL = ChessPiece.class.getResource("dukeWaveRed.gif");
        this.setIcon(new ImageIcon(imgURL));
    }
}
