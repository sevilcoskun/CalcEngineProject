package interfaceProcessing;

public interface MathProcessing{
    String SEPARATOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculation(double leftValue, double rightValue);
}