## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g. `"6,10,14".contains("1")`) not only performs poorly in loops but also introduces bugs due to substring matching ("1" matches "10").
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.stream(str.split(",")).collect(Collectors.toSet())`) before filtering to ensure correctness and O(1) performance.

## 2024-03-25 - Avoid Stream Overheads in Critical Paths
**Learning:** In Spring Boot eCommerce applications (like lilishop), calculations inside cart rendering loops (e.g., iterating through SKUs to sum quantities) can happen frequently. Using Java Stream operations (like `.stream().filter(...).mapToInt(...).sum()`) inside these loops creates unnecessary object allocations and iteration overhead. Furthermore, replacing variables used inside lambdas (like `v.forEach(i -> ... fSum ...)`) with mutable local variables from a `for` loop requires declaring a `final` copy of the variable (e.g., `final int finalFSum = fSum;`) to avoid "local variables referenced from a lambda expression must be final or effectively final" compilation errors.
**Action:** Prefer traditional `for` loops for simple aggregations and filtering in critical or frequently executed paths to reduce iteration overhead and object allocation. When refactoring streams to loops, carefully check if the aggregated variables are used inside subsequent lambda expressions and make them effectively final.
