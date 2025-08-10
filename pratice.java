import javax.swing.*;
import java.awt.*;

public class pratice extends JFrame {

    public pratice() {
        setTitle("Multiple Rectangles - Practice");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add custom panel
        add(new RectanglePanel());

        setVisible(true);
    }

    // Inner class for drawing rectangles
    class RectanglePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Set color and draw multiple rectangles
            g.setColor(Color.BLUE);
            g.fillRect(50, 50, 150, 100);

            g.setColor(Color.GREEN);
            g.fillRect(250, 100, 200, 120);

            g.setColor(Color.RED);
            g.drawRect(500, 200, 100, 150);

            g.setColor(Color.MAGENTA);
            g.drawRect(100, 300, 200, 150);

            g.setColor(Color.ORANGE);
            g.fillRect(400, 400, 120, 80);
        }
    }

    public static void main(String[] args) {
        new pratice();
    }
}
