package nn.layer;

import nn.Neuron;

import java.util.Arrays;

public class InputLayer extends Layer{
    private double[] dataInput;




    public InputLayer(int size, double[] dataInput) {
        super(size);

        this.dataInput = dataInput;

    }

    public void update(double[] dataInput, int size) {
        this.dataInput = dataInput;
        this.size = size;
        init();
    }
    @Override
    public void init() {
        Neuron neuron;
        for(int i = 0; i < size; i++) {
            neuron = new Neuron();
            neuron.setOutput(dataInput[i]);
            neurons[i] = neuron;
        }

    }


}
