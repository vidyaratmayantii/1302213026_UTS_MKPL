package lib;

public class TaxCalculationInput {
    private Salary monthlySalary;
    private Salary otherMonthlyIncome;
    private int numberOfMonthsWorked;
    private Deductible deductible;
    private MaritalStatus maritalStatus;
    private NumberOfChildren numberOfChildren;

    public TaxCalculationInput(Salary monthlySalary, Salary otherMonthlyIncome, int numberOfMonthsWorked, Deductible deductible, MaritalStatus maritalStatus, NumberOfChildren numberOfChildren) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.numberOfMonthsWorked = numberOfMonthsWorked;
        this.deductible = deductible;
        this.maritalStatus = maritalStatus;
        this.numberOfChildren = numberOfChildren;
    }

    // Getters
    public Salary getMonthlySalary() {
        return monthlySalary;
    }

    public Salary getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getNumberOfMonthsWorked() {
        return numberOfMonthsWorked;
    }

    public Deductible getDeductible() {
        return deductible;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public NumberOfChildren getNumberOfChildren() {
        return numberOfChildren;
    }
}
