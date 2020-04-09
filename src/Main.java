import exceptionHandling.InvalidStatementException;
import inheritance.*;
import interfaceProcessing.DynamicHelper;
import interfaceProcessing.MathProcessing;
import interfaceProcessing.PowerOf;
import otherDataTypes_stringEnum.CalculateHelper;

import java.io.OutputStream;

public class Main {
    public static void main(String args[]){

        useMathEquation();
        useCalculatorBase();
        useOtherDataTypes();
        useErrorHandling();
        useDynamicHelper();

    }

    static void useMathEquation(){
        System.out.println("Concept Class and use MathEquation Class");
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0, 50.0);
        equations[1] = new MathEquation('a', 125.0, 92.0);
        equations[2] = new MathEquation('s', 225.0, 17.0);
        equations[3] = new MathEquation('m', 11.0, 3.0);

        for(MathEquation equation : equations){
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        System.out.println("\nConcept Overload");
        MathEquation equationOverload = new MathEquation();
        System.out.println("(before execute) result = " + equationOverload.getResult());
        equationOverload.execute(9.0, 4.0);
        System.out.println("(after execute) result = " + equationOverload.getResult());
    }

    static void useCalculatorBase(){
        System.out.println("\nConcept Inheritance");
        CalculateBase[] calculators = {
                new Divider(100.0, 50.0),
                new Adder(25.0, 92.0),
                new Subtracter(225.0, 17.0),
                new Multiplier(11.0, 3.0)
        };

        for(CalculateBase calculator: calculators){
            calculator.calculate();
            System.out.println("Result = " + calculator.getResult());
        }
    }

    static void useOtherDataTypes(){
        System.out.println("\nConcept Other Data Types Concept - Enum");
        String[] statements = {
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for(String statement : statements){
            helper.process(statement);
            System.out.println(helper.toString());
        }
    }

    static void useErrorHandling(){
        System.out.println("\nConcept Exception Handling Concept");
        String[] statements = {
                "add 1.0", //Error: incorrect number of values
                "add xx 25.0", //Error: non-numeric data
                "addX 0.0 0.0", //Error: invalid opcode
                "add 25.0 92.0",
        };

        CalculateHelper helper = new CalculateHelper();
        for(String statement : statements){
            try{
                helper.process_with_exception(statement);
                System.out.println(helper.toString());
            } catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("      Original exception: " + e.getCause());
                }
            }
        }
    }

    static void useDynamicHelper(){
        System.out.println("\nConcept Interface and use DynamicHelper Class");
        String[] statements = {
                "add 25.0 92.0",
                "add 35.0 54.0",
                "power 5.0 2.0"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });

        for(String statement:statements){
            String output = helper.process(statement);
            System.out.println(output);
        }
    }
}
