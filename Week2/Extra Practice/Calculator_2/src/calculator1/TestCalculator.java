package calculator1;

public class TestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator advance = new Calculator();
		advance.setNum1(10.5);
		advance.setOperator('+');
		advance.setNum2(5.2);
		advance.performOperation();
		advance.setOperator('*');
		advance.setNum2(10);
		advance.performOperation();
		advance.setNum2(5);
		advance.setOperator('/');
		advance.performOperation();
		advance.getResults();
	}

}
