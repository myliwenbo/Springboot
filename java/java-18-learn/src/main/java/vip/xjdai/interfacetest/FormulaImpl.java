package vip.xjdai.interfacetest;

public class FormulaImpl implements Formula {

    @Override
    public double calculate(int a) {
        return sqrt(100);
    }

    public static void main(String[] args) {
        FormulaImpl formula=new FormulaImpl();
        double sqrt = formula.sqrt(100);
        System.out.println(sqrt);
    }
}
