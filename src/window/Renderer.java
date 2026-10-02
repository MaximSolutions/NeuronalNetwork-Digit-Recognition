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
        return (int) Math.round(value * 255);
    }
    private void brush(int cellX, int cellY) {
        double[][] brush = {
                {0.15, 0.45, 0.15},
                {0.45, 1.00, 0.45},
                {0.15, 0.45, 0.15}
        };

       for(int row = 0; row < 3; row++) {
           for(int col = 0; col < 3; col++) {
               int x = cellX + col -1;
               int y = cellY + row -1;

               if (x < 0 || x >= 24 || y < 0 || y > 24)  {
                   continue;
               }

               int index = x * 24 + y;

               grid.grid[index] = (float) Math.max(grid.grid[index], brush[row][col]);
           }
       }

    }
}
