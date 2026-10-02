package listeners;

import window.Grid;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends MouseAdapter {

    private boolean mousePressed;
    private int mouseX, mouseY;

    private int mouseOffsetX = -70;
    private int mouseOffsetY = -90;
    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed = true;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX() + mouseOffsetX;
        mouseY = e.getY() + mouseOffsetY;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX() + mouseOffsetX;
        mouseY = e.getY() + mouseOffsetY;

    }

    public boolean isInsideGrid(Grid grid){
        if(getMouseX() > Grid.OFFSET_X && getMouseX() < (grid.cellWidth * grid.width + Grid.OFFSET_X)){
            if(getMouseY() > Grid.OFFSET_Y && getMouseY() < (grid.cellHeight * grid.height + Grid.OFFSET_Y)){
                return true;
            }
        }
        return false;
    }

    public boolean getCellID(Grid grid) {
        return false;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }
}
