import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		double nbr1 = scan.nextDouble();
		double nbr2 = scan.nextDouble();

		System.out.println("Summan av talen är " + (nbr1 + nbr2));
		System.out.println("Differansen mellan talen är " + (nbr1 - nbr2));
		System.out.println("Produkten av talen är " + (nbr1 * nbr2));
		if (nbr2 != 0) {
			System.out.println("Kvoten mellan talen är " + (nbr1 / nbr2));
		} else {
			System.out.println("Kan inte dividera med noll!");
		}
	}
}
