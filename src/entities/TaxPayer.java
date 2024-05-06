package entities;

public class TaxPayer {
    private double salaryIncome;
    private double serviceIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.serviceIncome = serviceIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double salaryTax(double salaryIncome) {
        double monthSalary = salaryIncome / 12.0;
        return (monthSalary >= 5000) ? salaryIncome * 0.2 : (monthSalary < 3000) ? 0.0 : salaryIncome * 0.1;
    }

    public double serviceTax(double serviceIncome) {
        return serviceIncome * 0.15;
    }

    public double capitalTax(double capitalIncome) {
        return capitalIncome * 0.2;
    }

    public double grossTax(double salaryTax, double serviceTax, double capitalTax) {
        return salaryTax + serviceTax + capitalTax;
    }

    public double taxRebate(double grossTax) {
        double referenceValue = grossTax * 0.3;
        double rebatableValue = healthSpending + educationSpending;
        if (rebatableValue < referenceValue) {
            return rebatableValue;
        } else {
            return referenceValue;
        }
    }

    public double netTax(double grossTax, double taxRebate) {
        return grossTax - taxRebate;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServiceIncome() {
        return serviceIncome;
    }

    public void setServiceIncome(double serviceIncome) {
        this.serviceIncome = serviceIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public static String resumo(double grossTax, double taxRebate, double netTax) {
        return String.format(
                        "Imposto bruto total: R$%.2f%n" +
                        "Abatimento: R$%.2f%n" +
                        "Imposto devido: R$%.2f%n", grossTax, taxRebate, netTax);
    }
}

