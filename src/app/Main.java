package app;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Quantos contribuinte você vai digitar? ");
        int numContribuintes = sc.nextInt();
        System.out.println();

        for(int i = 0; i < numContribuintes; i++) {
            System.out.printf("Digite os dados do %dº contribuinte:%n", i + 1);
            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();
            System.out.println();

            taxPayers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
        }

        for (TaxPayer taxPayer : taxPayers){
            double salaryTax = taxPayer.salaryTax(taxPayer.getSalaryIncome());
            double serviceTax = taxPayer.serviceTax(taxPayer.getServiceIncome());
            double capitalTax = taxPayer.capitalTax(taxPayer.getCapitalIncome());
            double grossTax = taxPayer.grossTax(salaryTax, serviceTax, capitalTax);
            double taxRebate = taxPayer.taxRebate(grossTax);
            double netTax = taxPayer.netTax(grossTax, taxRebate);
            System.out.printf("Resumo do %dº contribuinte:%n", (taxPayers.indexOf(taxPayer) + 1));
            System.out.println(TaxPayer.resumo(grossTax, taxRebate, netTax));
        }

        sc.close();
    }
}
