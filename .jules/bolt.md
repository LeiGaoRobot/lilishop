
## 2024-05-24 - String Concatenation in HttpUtils Loops
**Learning:** String concatenation using `+=` inside a loop in Java creates a new `String` object on every iteration, leading to O(N^2) time complexity. In utility classes like `HttpUtils`, which may process large HTTP responses (like JSON API calls), this can become a significant memory and CPU bottleneck.
**Action:** Always replace string concatenation inside `while` or `for` loops with `StringBuilder` or `StringBuffer` to achieve O(N) performance, especially when reading stream responses line by line.
