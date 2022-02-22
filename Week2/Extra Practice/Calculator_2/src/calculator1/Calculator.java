package calculator1;

public class Calculator {
	private double num1;
	private double num2;
	private char operator;
	private double results;
	
	public Calculator() {
		
	}

	public void setNum1(double input) {
		this.num1 = input;
	}

	public void setNum2(double input) {
		this.num2 = input;
	}

	public void setOperator(char input) {
		this.operator = input;
	}

	public void performOperation() {
		results = 0;
		if (this.operator == '+') {
			double sum = num1 + num2;
			results += sum;
			setNum1(results);
		}
		if (this.operator == '-') {
			double difference = num1 - num2;
			results += difference;
			setNum1(results);
			
		}
		if (this.operator == '*') {
			double product = num1 * num2;
			results += product;
			setNum1(results);
		}
		if (this.operator == '/') {
			double quotient = num1 / num2;
			results += quotient;
		}
	}
	public void getResults() {
		System.out.println(results);
	}
	
}
