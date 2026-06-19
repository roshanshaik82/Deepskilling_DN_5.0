public class FinancialForecast {

    public static double forecast(double value, double rate, int years) {
        if(years == 0) {
            return value;
        }
        return forecast(value * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {

        double currentValue=5000;
        double growthRate=0.30;
        int years=2;
        double futureValue = forecast(currentValue, growthRate, years);

        System.out.println("Future Value after "+ years +" years: "+ futureValue);
    }
}