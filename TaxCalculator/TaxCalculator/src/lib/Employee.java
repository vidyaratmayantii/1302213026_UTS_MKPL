package lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private LocalDate dateJoined;
    private boolean isForeigner;
    private Gender gender;
    private SalaryGrade salaryGrade;
    private Spouse spouse;
    private List<Dependent> dependents;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
                    LocalDate dateJoined, boolean isForeigner, Gender gender, SalaryGrade salaryGrade) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;
        this.salaryGrade = salaryGrade;
        this.dependents = new ArrayList<>();
    }
    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouse = new Spouse(spouseName, spouseIdNumber);
    }

    public void addChild(String childName, String childIdNumber) {
        this.dependents.add(new Child(childName, childIdNumber));
    }

    public BigDecimal calculateMonthlySalary() {
        BigDecimal baseSalary = salaryGrade.getBaseSalary();
        if (isForeigner) {
            baseSalary = baseSalary.multiply(BigDecimal.valueOf(1.5));
        }
        return baseSalary;
    }

    public BigDecimal calculateAnnualIncomeTax() {
        int monthsWorked = calculateMonthsWorkedThisYear();
        BigDecimal taxableIncome = calculateTaxableIncome(monthsWorked);
        BigDecimal taxExemption = calculateTaxExemption();
        BigDecimal tax = taxableIncome.multiply(BigDecimal.valueOf(0.05)).subtract(taxExemption);
        return tax.max(BigDecimal.ZERO).setScale(0, RoundingMode.HALF_UP);
    }

    private int calculateMonthsWorkedThisYear() {
        LocalDate currentDate = LocalDate.now();
        return (currentDate.getYear() == dateJoined.getYear()) ?
               currentDate.getMonthValue() - dateJoined.getMonthValue() + 1 : 12;
    }

    private BigDecimal calculateTaxableIncome(int monthsWorked) {
        BigDecimal monthlySalary = calculateMonthlySalary();
        return monthlySalary.multiply(BigDecimal.valueOf(monthsWorked));
    }

    private BigDecimal calculateTaxExemption() {
        BigDecimal taxExemption = BigDecimal.valueOf(54000000);
        if (spouse != null) {
            taxExemption = taxExemption.add(BigDecimal.valueOf(4500000));
        }
        int childCount = dependents.size();
        taxExemption = taxExemption.add(BigDecimal.valueOf(Math.min(childCount, 3) * 4500000));
        return taxExemption;
    }
}
