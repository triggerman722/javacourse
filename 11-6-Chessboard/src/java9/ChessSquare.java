package java9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;

/**
 * Created by greg on 08/07/17.
 */
public class ChessSquare  extends Panel{

    public ChessSquare(boolean isBlack) {
        this.setLayout(new BorderLayout());
        if (isBlack) {
            setBackground(Color.black);
        } else {
            setBackground(Color.white);
        }
    }
}
