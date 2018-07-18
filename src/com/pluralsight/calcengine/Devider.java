package com.pluralsight.calcengine;

public class Devider extends CalculateBase{

    public Devider(){}
    public Devider(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }
    @Override
    public void calculate() {
        double value = getLeftVal() / getRightVal();
        setResult(value);
    }
}
