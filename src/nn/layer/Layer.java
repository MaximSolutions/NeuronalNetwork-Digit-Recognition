package nn.layer;

import nn.Neuron;
import utils.Utils;

public abstract class Layer {


    public Neuron[] neurons;
    public double[][] weigths;
    public double[] biases;
    public Neuron[] neuronsBefore;
    public int size;


    public Layer(int size) {
        this.size = size;
        neurons = new Neuron[size];
    }

    public abstract void init();
    public void randomWeights() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < neuronsBefore.length; j++) {
                weigths[i][j] = Utils.getRandomNumber(-10, 10);
            }
        }
    }

    public void randomBiases() {
        for(int i = 0; i < size; i++) {

            biases[i] = Utils.getRandomNumber(-20, 20);

        }
    }
}
