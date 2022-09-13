package Assignment.Controller;

import javax.swing.border.Border;
import java.awt.*;

public class RoundedButtonController implements Border {

        private int r;
        public RoundedButtonController(int r) {
            this.r = r;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.r-26, this.r-10, this.r-28, this.r-10);
        }
        public boolean isBorderOpaque() {
            return true;
        }
        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            g.drawRoundRect(x, y, width, height, r, r);
        }

}
