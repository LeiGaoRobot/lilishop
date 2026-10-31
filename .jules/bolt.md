## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-10-30 - [Optimize delimited string checks inside loops using Set]
**Learning:** Using `String.contains()` or Stream `.anyMatch()` on a delimited string (like `"10,12,14".contains("1")`) inside loops can cause subtle correctness bugs due to partial matches and suffers from O(N) performance.
**Action:** Always parse the delimited string into a `LinkedHashSet` beforehand to guarantee O(1) lookup time, ensure exact matches, and maintain insertion order unless downstream logic explicitly ignores it.
