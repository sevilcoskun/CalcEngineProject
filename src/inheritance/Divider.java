package inheritance;

public class Divider extends CalculateBase {
    public Divider() {}

    public Divider(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public void calculate(){
        double value;
        if(getRightValue() != 0.0){
            value = getLeftValue() / getRightValue();
        }
        else{ value = 0.0; }
        setResult(value);
    }
}
