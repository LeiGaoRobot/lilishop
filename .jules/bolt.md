## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g. `"6,10,14".contains("1")`) not only performs poorly in loops but also introduces bugs due to substring matching ("1" matches "10").
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.stream(str.split(",")).collect(Collectors.toSet())`) before filtering to ensure correctness and O(1) performance.

## 2024-05-17 - String Concatenation Bottlenecks in Loops
**Learning:** Found multiple instances of string concatenation using `+=` inside loops (e.g., `StringUtils.getRandStr()`) causing O(N^2) time complexity. Additionally, local StringBuffers were used where Thread safety wasn't needed, causing synchronization overhead.
**Action:** Always replace `+=` inside loops with `StringBuilder`, and prefer `StringBuilder` over `StringBuffer` for local string building when thread-safety isn't required. Use `append(char)` instead of `append(String)` for single characters to avoid implicit string creation.
