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

        g2.fillRect(0,0, getWidth(), getHeight());

        if(window.mouseHandler.isMousePressed() && window.mouseHandler.isInsideGrid(grid)){
            int relativeMouseX = window.mouseHandler.getMouseX() + Grid.OFFSET_X;
            int relativeMouseY = window.mouseHandler.getMouseY() + Grid.OFFSET_Y;

            int cellX = relativeMouseX / grid.width;
            int cellY = relativeMouseY / grid.height;

            System.out.println(cellX);

           brush(cellX, cellY);
        }

        drawGrid(g2);

        repaint();
    }

    private void drawGrid(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.drawRect(Grid.OFFSET_X, Grid.OFFSET_Y, grid.width * grid.cellWidth, grid.height * grid.cellHeight);

        int grayScale = 0;
        double value = 0;
        for(int row = 0; row < 24; row++) {
            for(int col = 0; col < 24; col++) {
                value = grid.grid[row * 24 + col];
                grayScale = determineGrayScale(value);
                g2.setColor(new Color(grayScale, grayScale, grayScale));
                int relativeMouseX = window.mouseHandler.getMouseX() * grid.cellWidth + Grid.OFFSET_X;
                int relativeMouseY = window.mouseHandler.getMouseY() * grid.cellHeight + Grid.OFFSET_Y;

                int cellX = relativeMouseX % grid.width;
                int cellY = relativeMouseY % grid.height;



                if(value == 0) continue;
                g2.fillRect(Grid.OFFSET_X + row * grid.cellWidth, Grid.OFFSET_Y + col * grid.cellHeight, grid.cellWidth, grid.cellHeight);
            }
        }

    }

    private int determineGrayScale(double value) {
        if (value == 1) {
            return 255;
        }
        if(value < 1 && value >= 0.7) {
            return 200;
        }
        if(value < 0.7 && value >= 0.4) {
            return 150;
        }
        if(value < 0.5 && value >= 0.1) {
            return 100;
        }
        return 0;
    }
    private void brush(int x, int y) {
        try {
            grid.grid[x * 24 + y] = 1.0f;
            grid.grid[x * 24 + y + 1] = 0.7f;
            grid.grid[x * 24 + y + 24] =  0.7;
            grid.grid[x * 24 + y + 25] = 0.1f;
        }catch (ArrayIndexOutOfBoundsException e) {

        }

    }
}
