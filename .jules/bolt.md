## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-10-15 - Set Operations inside loops
**Learning:** Checking for list membership in loops `List.contains()` scales poorly since it executes in O(N). Parsing strings out and checking collections in loops without hoisting also hurts performance.
**Action:** When finding loops looking to see if items exist `List.contains(x)`, parse to a `Set` once outside the loop instead and lookup using `Set.contains(x)` for an O(1) time complexity. Ensure correct types like `Set` from `java.util.Set` are included to not break compilation.
