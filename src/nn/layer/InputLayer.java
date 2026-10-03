package nn.layer;

import nn.Neuron;

import java.util.Arrays;

public class InputLayer extends Layer{
    private double[] dataInput;




    public InputLayer(int size, double[] dataInput) {
        super(size);

        this.dataInput = dataInput;

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
