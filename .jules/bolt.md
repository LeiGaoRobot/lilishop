## 2024-03-24 - String concatenation in loops
**Learning:** Using `+=` for string concatenation inside a loop creates a new `StringBuilder` instance in every iteration, leading to excessive garbage collection overhead. Using `StringBuffer` for local variables also incurs unnecessary synchronization overhead compared to `StringBuilder`.
**Action:** Use `StringBuilder` explicitly for string concatenation inside loops and for local variable string building in utility classes.
