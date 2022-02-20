package calculator1;

public class TestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator simple = new Calculator();
		simple.setNum1(10.5);
		simple.setNum2(5.2);
		simple.setOperator('+');
		simple.performOperation();
		simple.getResults();
	}

}
