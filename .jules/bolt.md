## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-27 - [Bug with String.contains on Delimited Strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g., `"10,12,14".contains("1")`) causes subtle correctness bugs due to partial substring matches.
**Action:** Always parse delimited strings into a `Set` (e.g., `new HashSet<>(Arrays.asList(str.split(",")))`) before checking for element existence, and hoist this parsing outside of loops.
