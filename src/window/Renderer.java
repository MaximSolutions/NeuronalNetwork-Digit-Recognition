package window;

import listeners.MouseHandler;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {

    private Window window;
    private Grid grid;

    public Renderer(Window _window) {
        this.window = _window;
        this.grid = new Grid(24, 24, 20, 20);
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.BLACK);
        g2.fillRect(100, 100, 100, 100);
        if(window.mouseHandler.isMousePressed() && window.mouseHandler.isInsideGrid(grid)){

            g2.fillRect(window.mouseHandler.getMouseX() - 12, window.mouseHandler.getMouseY() - 20, 10,10);
        }

        drawGrid(g2);

        repaint();
    }

    private void drawGrid(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.drawRect(Grid.OFFSET_X, Grid.OFFSET_Y, grid.width * grid.cellWidth, grid.height * grid.cellHeight);
    }
}
