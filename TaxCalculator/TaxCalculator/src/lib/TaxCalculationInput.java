package lib;

public class TaxCalculationInput {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int numberOfMonthsWorked;
    private int deductible;
    private boolean isMarried;
    private int numberOfChildren;

    public TaxCalculationInput(int monthlySalary, int otherMonthlyIncome, int numberOfMonthsWorked, int deductible, boolean isMarried, int numberOfChildren) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.numberOfMonthsWorked = numberOfMonthsWorked;
        this.deductible = deductible;
        this.isMarried = isMarried;
        this.numberOfChildren = numberOfChildren;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getNumberOfMonthsWorked() {
        return numberOfMonthsWorked;
    }

    public int getDeductible() {
        return deductible;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
}
