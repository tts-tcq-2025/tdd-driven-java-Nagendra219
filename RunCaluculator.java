package caluculator;

public class RunCaluculator {
	
	 public static void main(String[] args) {
	        StringCalculatorConfig config = new StringCalculatorConfig();
	        StringCalculator calc = new StringCalculator(config);

	        System.out.println(calc.add("1,2,3").getSum());                 // 6
	        System.out.println(calc.add("//;\n1;2").getSum());              // 3
	        System.out.println(calc.add("//[***]\n1***2***3").getSum());    // 6

	        try {
	            calc.add("1,-2,3");
	        } catch (Exception e) {
	            System.out.println(e.getMessage()); // Negatives not allowed: [-2]
	        }
	    }

}
