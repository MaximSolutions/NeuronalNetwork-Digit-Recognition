package nn;

import utils.Constants;

public class Neuron {


    public double bias;
    public double[] inputValues;
    public double[] weights;

    private double output;

    public Neuron(double [] inputValues, double [] weights, double bias) {
        this.inputValues = inputValues;
        this.weights = weights;
        this.bias = bias;
        this.output = calculateOutput();
    }
    public Neuron() {

    }

    public double calculateOutput() {
        double output = 0;
        for(int i = 0; i < inputValues.length; i++) {
            output += (weights[i] * inputValues[i]);
        }
        output -= bias;

        return sigmoid(output);
    }



    private double sigmoid(double value) {
        return (1 / (1 + Math.pow(Constants.E, -value)));
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public double getOutput() {
        return output;
    }
}
