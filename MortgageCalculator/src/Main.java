import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final int MIN_PRINCIPAL = 1000;
        final int MAX_PRINCIPAL = 1_000_000;
        final float MIN_ANNUAL_INTEREST_RATE = 1;
        final float MAX_ANNUAL_INTEREST_RATE = 30;
        final byte MIN_LOAN_TERM_YEARS = 1;
        final byte MAX_LOAN_TERM_YEARS = 30;

        Scanner scanner = new Scanner(System.in);

        int principal = getValidPrincipal(scanner, MIN_PRINCIPAL, MAX_PRINCIPAL);
        float annualInterestRate = getValidAnnualInterestRate(scanner, MIN_ANNUAL_INTEREST_RATE, MAX_ANNUAL_INTEREST_RATE);
        byte loanTermInYears = getValidLoanTermYears(scanner, MIN_LOAN_TERM_YEARS, MAX_LOAN_TERM_YEARS);

        // Calculate the monthly payment
        double monthlyInterestRate = annualInterestRate / (MONTHS_IN_YEAR * 100);
        int loanTermInMonths = loanTermInYears * MONTHS_IN_YEAR;
        double monthlyPayment = calculateMonthlyPayment(principal, monthlyInterestRate, loanTermInMonths);

        System.out.println("Your estimated monthly mortgage payment is: " + monthlyPayment);

        scanner.close();
    }

    private static int getValidPrincipal(Scanner scanner, int min, int max) {
        int principal;
        while (true) {
            System.out.print("Enter principal: ");
            principal = scanner.nextInt();
            if (principal >= min && principal <= max) {
                return principal;
            }
            System.out.println("Enter a valid value between " + min + " and " + max);
        }
    }

    private static float getValidAnnualInterestRate(Scanner scanner, float min, float max) {
        float annualInterestRate;
        while (true) {
            System.out.print("Enter annual interest rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= min && annualInterestRate <= max) {
                return annualInterestRate;
            }
            System.out.println("Enter a valid value between " + min + " and " + max);
        }
    }

    private static byte getValidLoanTermYears(Scanner scanner, byte min, byte max) {
        byte loanTermInYears;
        while (true) {
            System.out.print("Enter loan term in years: ");
            loanTermInYears = scanner.nextByte();
            if (loanTermInYears >= min && loanTermInYears <= max) {
                return loanTermInYears;
            }
            System.out.println("Enter a valid value between " + min + " and " + max);
        }
    }

    private static double calculateMonthlyPayment(int principal, double monthlyInterestRate, int loanTermInMonths) {
        return principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermInMonths))
                / (Math.pow(1 + monthlyInterestRate, loanTermInMonths) - 1);
    }
}
