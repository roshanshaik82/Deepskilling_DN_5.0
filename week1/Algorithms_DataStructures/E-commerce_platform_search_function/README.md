# E-commerce Platform Search Function

## Exercise 2

### Scenario
You are working on the search functionality of an e-commerce platform. The search operation must be optimized for fast performance when dealing with a large number of products.

---

## Objective

- Understand Asymptotic Notation and Big O Analysis.
- Implement Linear Search and Binary Search algorithms.
- Compare the performance of both searching techniques.
- Determine the most suitable search algorithm for an e-commerce platform.

---

## Step 1: Understand Asymptotic Notation

### What is Big O Notation?

Big O Notation is used to measure the efficiency of an algorithm by describing how its execution time grows as the input size increases.

It helps developers:
- Analyze algorithm performance.
- Compare different algorithms.
- Select the most efficient solution for large datasets.

### Search Operation Scenarios

#### Best Case

The required product is found immediately.

Example:

```text
Products: [101, 102, 103, 104]

Search: 101
```

Time Complexity:

```text
O(1)
```

---

#### Average Case

The required product is found somewhere in the middle.

Example:

```text
Products: [101, 102, 103, 104, 105]

Search: 103
```

Time Complexity:

```text
O(n)
```

---

#### Worst Case

The required product is at the end or not present.

Example:

```text
Products: [101, 102, 103, 104, 105]

Search: 105
```

Time Complexity:

```text
O(n)
```

---

## Step 2: Create Product Class

### Product.java

```java
class Product {

    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}
```

### Explanation

- productId → Unique identifier for a product.
- productName → Name of the product.
- category → Product category.
- Constructor initializes product details.

---

## Step 3: Implement Search Algorithms

### Linear Search

Linear Search checks each product one by one until the required product is found.

#### LinearSearch.java

```java
class LinearSearch {

    public static Product search(Product[] products, int id) {

        for (Product product : products) {

            if (product.productId == id) {
                return product;
            }
        }

        return null;
    }
}
```

### Working of Linear Search

Example:

```text
101 → 102 → 103 → 104
```

Searching for:

```text
104
```

Comparisons:

```text
101 ❌
102 ❌
103 ❌
104 ✅
```

Product found after checking elements sequentially.

---

### Binary Search

Binary Search works only on sorted data.

It repeatedly divides the array into two halves until the target product is found.

#### BinarySearch.java

```java
class BinarySearch {

    public static Product search(Product[] products, int id) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            }

            else if (products[mid].productId < id) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return null;
    }
}
```

### Working of Binary Search

Sorted Array:

```text
101 102 103 104 105 106 107
```

Search:

```text
106
```

Step 1:

```text
Middle = 104
```

Since:

```text
106 > 104
```

Search in right half.

Step 2:

```text
105 106 107
```

Middle:

```text
106
```

Product Found.

---

## Step 4: Analysis

### Linear Search Complexity

| Case | Complexity |
|--------|-----------|
| Best Case | O(1) |
| Average Case | O(n) |
| Worst Case | O(n) |

### Binary Search Complexity

| Case | Complexity |
|--------|-----------|
| Best Case | O(1) |
| Average Case | O(log n) |
| Worst Case | O(log n) |

---

## Main Program

### Main.java

```java
public class Main {

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(104, "Watch", "Accessories")
        };

        Product linearResult = LinearSearch.search(products, 102);

        if (linearResult != null)
            System.out.println("Linear Search Found: " + linearResult.productName);

        Product binaryResult = BinarySearch.search(products, 103);

        if (binaryResult != null)
            System.out.println("Binary Search Found: " + binaryResult.productName);
    }
}
```

---

## Output

```text
Linear Search Found: Phone
Binary Search Found: Shoes
```

---

## Conclusion

Linear Search is simple and works on unsorted data but becomes slower as the number of products increases.

Binary Search is significantly faster because it reduces the search space by half during each iteration. However, it requires the products to be stored in sorted order.

Therefore, Binary Search is the preferred search algorithm for large-scale e-commerce platforms due to its efficient O(log n) time complexity.