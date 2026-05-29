## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-29 - O(N) Substring Match to O(1) Set Lookup inside Stream Filter
**Learning:** Found an invariant string parsing operation `seckill.getHours().split(",")` happening redundantly for every element in a stream filter via `String.contains()`. Additionally, using `String.contains()` on comma-separated list like "10,12" has unintended logical bugs where `"10,12".contains("1")` wrongly evaluates to `true`.
**Action:** When seeing `delimitedString.contains()` in a loop or stream filter, pull the split operation outside the loop and convert the array to a `Set` (e.g. `new HashSet<>(Arrays.asList(...))`). This reduces complexity from O(M*N) string scans to O(N) O(1) hash lookups, while strictly matching the tokens and fixing substring bugs. Ensure to add explanatory comments.
