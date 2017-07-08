package java9;

import javax.swing.*;
import java.awt.*;

/**
 * Created by greg on 08/07/17.
 */
public class ChessSquare  extends JPanel{

    public ChessSquare(boolean isBlack) {
        this.setLayout(new BorderLayout());
        if (isBlack) {
            setBackground(Color.black);
        } else {
            setBackground(Color.white);
        }
    }
}
