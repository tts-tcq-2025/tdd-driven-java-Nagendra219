package caluculator;


public class StringCalculatorConfig {
    private boolean ignoreNumbersGreaterThan1000 = true;

    public boolean isIgnoreNumbersGreaterThan1000() {
        return ignoreNumbersGreaterThan1000;
    }

    public void setIgnoreNumbersGreaterThan1000(boolean ignoreNumbersGreaterThan1000) {
        this.ignoreNumbersGreaterThan1000 = ignoreNumbersGreaterThan1000;
    }
}
