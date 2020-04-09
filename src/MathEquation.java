public class MathEquation {
    private double leftValue;
    private double rightValue;
    private char opCode = 'a';
    private double result;

    //Getter and Setter
    public double getLeftValue() { return leftValue; }
    public double getRightValue() { return rightValue; }
    public char getOpCode() { return opCode; }

    public void setLeftValue(double leftValue) { this.leftValue = leftValue; }
    public void setRightValue(double rightValue) { this.rightValue = rightValue; }
    public void setOpCode(char opCode) { this.opCode = opCode; }

    public double getResult() { return result; }

    //Constructors
    public MathEquation() {}

    public MathEquation(char opCode) { this.opCode = opCode; }

    public MathEquation(char opCode, double leftValue, double rightValue){
        this.opCode = opCode;
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    //Class specific methods
    public void execute(double leftValue, double rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        execute();
    }

    public void execute(int leftValue, int rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        execute();

        result = (int)result;
    }

    public void execute(){
        switch (opCode){
            case 'a':
                result = leftValue + rightValue;
                break;
            case 's':
                result = leftValue - rightValue;
                break;
            case 'm':
                result = leftValue * rightValue;
                break;
            case 'd':
                result = rightValue != 0.0 ? leftValue/rightValue : 0;
                break;
            default:
                System.out.println("Error - invalid opCode");
                result = 0.0;
                break;
        }
    }
}
