package nn;

import nn.layer.HiddenLayer;
import nn.layer.InputLayer;
import nn.layer.Layer;
import nn.layer.OutputLayer;

import java.awt.desktop.AppHiddenEvent;
import java.util.Arrays;

public class NeuronalNetwork {


    private InputLayer inputLayer;
    private HiddenLayer hiddenLayerOne, hiddenLayerTwo;
    private OutputLayer outputLayer;
    private int size;


    public NeuronalNetwork(double[] dataInput) {
        size = dataInput.length;
        inputLayer = new InputLayer(size, dataInput);
        inputLayer.init();



        hiddenLayerOne = new HiddenLayer(16, inputLayer.neurons);
        hiddenLayerOne.init();
        hiddenLayerTwo = new HiddenLayer(16, hiddenLayerOne.neurons);
        hiddenLayerTwo.init();

        outputLayer = new OutputLayer(10, hiddenLayerTwo.neurons);
        outputLayer.init();

        double[] goal = {0,0,0,1,0,0,0,0,0,0};



    }

    public void update(double[] dataInput) {
        inputLayer.update(dataInput, dataInput.length);
        hiddenLayerOne.update(inputLayer.neurons);
        hiddenLayerTwo.update(hiddenLayerOne.neurons);
        outputLayer.update(hiddenLayerTwo.neurons);


    }

    public OutputLayer getOutputLayer() {
        return outputLayer;
    }
}
