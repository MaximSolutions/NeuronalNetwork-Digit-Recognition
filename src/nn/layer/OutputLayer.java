package nn.layer;

import nn.Neuron;

public class OutputLayer extends Layer{

    private double[] output;

    public OutputLayer(int size, Neuron[] neuronsBefore) {
        super(size);
        this.neuronsBefore = neuronsBefore;
        this.neurons = new Neuron[size];
        this.weigths = new double[size][neuronsBefore.length];
        this.biases = new double[size];

        randomBiases();
        randomWeights();
    }
    @Override
    public void init() {
        double[] inputValues = new double[neuronsBefore.length];
        for(int i = 0; i < size; i++) {

            for(int j = 0; j < neuronsBefore.length; j++) {
                inputValues[j] = neuronsBefore[j].getOutput();
            }

            Neuron neuron = new Neuron(inputValues, weigths[i], biases[i]);

            neurons[i] = neuron;

        }
        initOutputValues();
    }
    private void initOutputValues() {
        this.output = new double[size];
        for(int i = 0; i < size; i++) {
            output[i] = neurons[i].getOutput();
        }
    }

    public double[] getOutput() {
        return output;
    }
}
