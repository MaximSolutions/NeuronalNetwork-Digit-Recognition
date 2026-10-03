package window;

import listeners.MouseHandler;
import nn.NeuronalNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.jar.JarFile;

public class Window extends JFrame {

    private Renderer renderer;
    public MouseHandler mouseHandler;

    private Grid grid;

    private JButton clearButton;
    private NeuronalNetwork neuronalNetwork;
    public Window(int _width, int _height, String title) {


        grid = new Grid(24, 24, 20, 20);;
        neuronalNetwork = new NeuronalNetwork(grid.grid);
        mouseHandler = new MouseHandler();

        renderer = new Renderer(this);
        renderer.setBounds(0, 0, getWidth(), getHeight());

        initClearButton();
        renderer.add(clearButton);



        this.setSize(_width, _height);
        this.setTitle(title);
        this.setResizable(false);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.add(renderer);
        this.setVisible(true);
        this.setLayout(null);
    }

    public void updateNeuronalNet() {

    }
    private void initClearButton() {
        clearButton = new JButton("Clear");
        clearButton.setBounds(0, 0, 200, 100);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Arrays.fill(grid.grid, 0);
            }
        });
    }

    public Grid getGrid() {
        return grid;
    }

    public NeuronalNetwork getNeuronalNetwork() {
        return neuronalNetwork;
    }
}

