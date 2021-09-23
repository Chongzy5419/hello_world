import java.util.Scanner;
import java.util.ArrayList;

public class PolynomialDivision extends Polynomial {
	
	public static void main(String[] args) {
		
		System.out.println("Enter the dividend");
		ArrayList<Integer> dividend = getPolynomial();
		System.out.println("Enter the divisor");
		ArrayList<Integer> divisor = getPolynomial();
		
		Answer answer = longDivision(dividend, divisor);
		answer.printAnswer();
	
	}
	
	public static Answer longDivision(ArrayList<Integer> remainder, ArrayList<Integer> divisor) {
		Answer answer = new Answer();
		ArrayList<Integer> quotient = new ArrayList<>();
		ArrayList<Integer> product = new ArrayList<>();
		
		int quotientDegree = remainder.size() - divisor.size();
		int coefficient;
		int index = 0;
		
		while(!isLastTerm(remainder, divisor, index)) {
			
			if (isQuotientZero(remainder, divisor, index)) {
				quotient.add(0);
				index++;
			}
			else {
				coefficient = remainder.get(index)/divisor.get(0);
				quotient.add(coefficient);
				product = getProduct(divisor, coefficient, quotientDegree - index);
				
				while (product.size() < remainder.size()) {
					product.add(0, 0);
				}
				
				remainder = getDifference(remainder, product); 
				index++;
			}
		}
		answer.remainder = removeLeadingZeros(remainder);
		answer.quotient = removeLeadingZeros(quotient);
		return answer;
	}
	
	public static ArrayList<Integer> getProduct(ArrayList<Integer> divisor, int quotientCoefficient, int quotientIndex){
		ArrayList<Integer> product = new ArrayList<>();
		
		for(int i=1; i <= (divisor.size() + quotientIndex) ; i++) {
			if (i <= divisor.size()) {
				product.add(divisor.get(i-1) * quotientCoefficient);
			}
			else {
				product.add(0);
			}
		}
		
		return product;
	}
	
	public static ArrayList<Integer> getDifference(ArrayList<Integer> firstPoly, ArrayList<Integer> secondPoly){
				
		for(int i=0; i < (firstPoly.size()); i++) {
			firstPoly.set(i, (firstPoly.get(i) - secondPoly.get(i)));
		}
		
		return firstPoly;
	}
	
	public static boolean isQuotientZero(ArrayList<Integer> polynomial, ArrayList<Integer> divisor, int index) {
		
		if (Math.abs(polynomial.get(index)) < Math.abs(divisor.get(0)))
			return true;
		else return false;
		
	}
	
	public static boolean isLastTerm(ArrayList<Integer> polynomial, ArrayList<Integer> divisor, int index) {
		
		if (polynomial.size() - index < divisor.size())
			return true;
		else return false;
		
	}

}

//another class

class Polynomial {
	
	private static Scanner in;

	public static ArrayList<Integer> getPolynomial() {
		
		ArrayList<Integer> coefficients = new ArrayList<>();
		int degree;
		in = new Scanner(System.in);
		System.out.print("Enter the degree of the polynomial: ");
		degree = in.nextInt();
		
		for (int i=0; i <= degree; i++) {
			System.out.print("Enter the coefficient for degree " + (degree-i) + ": ");
			coefficients.add(in.nextInt());
		}
		
		return coefficients;
	}
	
	public static void printPolynomial(ArrayList<Integer> polynomial) {
		int i = 0;
		System.out.print("< ");
		while (i < polynomial.size()) {
			if (i == (polynomial.size() - 1)) {
				System.out.println(polynomial.get(i) + " >");
			}
			else {
				System.out.print(polynomial.get(i) + ", ");
			}
			i++;
		}
	}
	
	public static ArrayList<Integer> removeLeadingZeros(ArrayList<Integer> polynomial){
			
		if (polynomial.get(0) == 0 && (polynomial.size() > 1)) {
			polynomial.remove(0);
			polynomial = removeLeadingZeros(polynomial);
		}
		return polynomial;
	}

}

//another class


class Answer extends Polynomial {
	ArrayList<Integer> quotient = new ArrayList<>();
	ArrayList<Integer> remainder = new ArrayList<>();
	
	public void printAnswer() {
		System.out.println("The quotient is:");
		printPolynomial(quotient);
		System.out.println("The remainder is:");
		printPolynomial(remainder);
	}
}

