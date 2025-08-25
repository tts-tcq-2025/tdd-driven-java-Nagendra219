package caluculator;

import java.util.List;

public class CalculationResult {
    private int sum;
    private List<Integer> numbers;

    public CalculationResult() {}

    public CalculationResult(int sum, List<Integer> numbers) {
        this.sum = sum;
        this.numbers = numbers;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
