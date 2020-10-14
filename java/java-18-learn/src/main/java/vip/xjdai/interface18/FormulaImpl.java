package vip.xjdai.interface18;

public class FormulaImpl implements Formula {

    @Override
    public double calculate(int a) {
        return sqrt(100);
    }

    public static void main(String[] args) {
        FormulaImpl formula = new FormulaImpl();
        System.out.println(formula.calculate(100));
    }
}
