## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-07-29 - Optimize List.contains to Set.add for duplicate checking
**Learning:** Using `List.contains()` inside a loop causes O(N^2) time complexity, which is a significant performance bottleneck for large datasets (e.g., when verifying duplicate SKUs across promotions). Additionally, repeating O(N) operations like `String.split` inside a loop degrades performance due to excessive array allocations and garbage collection overhead.
**Action:** Hoist repetitive operations (like `String.split` and converting to a Set) outside of loops to eliminate redundant work. Replace `List` with `Set` for uniqueness constraints, and utilize `Set.add()` to perform both the existence check and insertion safely in a single O(1) operation.
