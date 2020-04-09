package inheritance;

public abstract class CalculateBase {
    private double leftValue;
    private double rightValue;
    private double result;

    //Getters and Setters
    public double getLeftValue() { return leftValue; }
    public double getRightValue() { return rightValue; }
    public double getResult() { return result; }

    public void setLeftValue(double leftValue) { this.leftValue = leftValue; }
    public void setRightValue(double rightValue) { this.rightValue = rightValue; }
    public void setResult(double result) { this.result = result; }

    //Constructors
    public CalculateBase(){}

    public CalculateBase(double leftValue, double rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public abstract void calculate();
}
