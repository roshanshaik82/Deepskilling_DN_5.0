# Exercise 7: Financial Forecasting

## Scenario

Develop a financial forecasting tool that predicts future values based on historical data using a recursive approach.

---

## 📚 Understanding Recursive Algorithms

### What is Recursion?

Recursion is a programming technique in which a method calls itself to solve a problem. It breaks a large problem into smaller subproblems until a stopping condition (base case) is reached.

### Why Use Recursion in Financial Forecasting?

Financial forecasting often involves repeatedly applying a growth rate over multiple years. Recursion simplifies this process by using the same calculation logic for each forecasting period.

### Example

Suppose an investment of ₹1000 grows at 10% annually:

| Year | Value |
| ---- | ----- |
| 0    | ₹1000 |
| 1    | ₹1100 |
| 2    | ₹1210 |
| 3    | ₹1331 |

The recursive function calculates each year's value and continues until the desired forecast period is reached.

---

## 🛠 Setup

### Inputs Required

* Current Value
* Growth Rate
* Number of Years

### Formula

Future Value = Current Value × (1 + Growth Rate)

### Method Signature

```java
public static double forecast(double value, double rate, int years)
```

---

## 💻 Implementation

### Java Code

```java
public class FinancialForecast {

    public static double forecast(double value, double rate, int years) {

        if (years == 0) {
            return value;
        }

        return forecast(value * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {

        double currentValue = 1000;
        double growthRate = 0.10;
        int years = 3;

        double futureValue = forecast(currentValue, growthRate, years);

        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}
```

### Output

```
Future Value after 3 years: 1331.0
```

### Dry Run

```
forecast(1000, 0.10, 3)
        ↓
forecast(1100, 0.10, 2)
        ↓
forecast(1210, 0.10, 1)
        ↓
forecast(1331, 0.10, 0)
        ↓
Return 1331
```

---

## 📊 Analysis

### Time Complexity

The recursive function performs one recursive call for each year.

T(n) = T(n-1) + O(1)

Therefore,

```
Time Complexity = O(n)
```

Where n is the number of years being forecasted.

### Space Complexity

Each recursive call is stored in the call stack.

```
Space Complexity = O(n)
```

### Optimization Techniques

#### 1. Memoization

Store previously calculated results and reuse them when needed.

#### 2. Dynamic Programming

Build the solution iteratively and store intermediate values.

#### 3. Iterative Approach

```java
for(int i = 0; i < years; i++) {
    value = value * (1 + rate);
}
```

This reduces memory usage because no recursive call stack is created.

### Complexity Comparison

| Approach  | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| Recursion | O(n)            | O(n)             |
| Iteration | O(n)            | O(1)             |

---

## ✅ Conclusion

This project demonstrates how recursion can be used in financial forecasting to predict future values based on historical growth rates. The recursive solution is easy to understand and implement, while iterative solutions can be used to improve memory efficiency for large forecasting periods.
