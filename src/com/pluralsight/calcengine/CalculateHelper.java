package com.pluralsight.calcengine;

public class CalculateHelper {

    private static final char ADD_SYMBOL = '+';
    private static final char SUBSTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DEVIDE_SYMBOL = '/';

    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    public void process (String statement) {
        String[] parts = statement.split(" ");
        String commandString = parts[0];
        leftValue = Double.parseDouble(parts[1]);
        rightValue = Double.parseDouble(parts[2]);

        setCommandFromString(commandString);

        CalculateBase calculatator = null;

        switch (command) {
            case Add:
                calculatator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculatator = new Substractor(leftValue, rightValue);
                break;
            case Multiply:
                calculatator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculatator = new Devider(leftValue, rightValue);
                break;
        }

        calculatator.calculate();
        result = calculatator.getResult();

    }

    private void setCommandFromString(String commandString) {

        if(commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if (commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
        else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
    }

    @Override
    public String toString() {
        char symbol = ' ';
        switch(command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBSTRACT_SYMBOL;
                break;
            case Divide:
                symbol = DEVIDE_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(" ");
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }
}
