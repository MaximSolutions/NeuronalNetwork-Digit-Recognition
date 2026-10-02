package window;

import listeners.MouseHandler;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarFile;

public class Window extends JFrame {

    private Renderer renderer;
    public MouseHandler mouseHandler;




    public Window(int _width, int _height, String title) {

        mouseHandler = new MouseHandler();

        renderer = new Renderer(this);
        renderer.setSize(getWidth(), getHeight());

        this.setSize(_width, _height);
        this.setTitle(title);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.add(renderer);
        this.setVisible(true);
    }


}

