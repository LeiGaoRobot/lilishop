## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-14 - Optimize List.contains inside loops
**Learning:** Found O(N^2) complexity in seckill batch processing logic where `List.contains()` was used inside loops and stream filters to check string membership.
**Action:** Always convert comma-separated string lists to a `Set` (e.g., `HashSet`) before checking membership inside loops, and use `Set.add()` for O(1) duplicate checking rather than `List.contains()` followed by `List.add()`.
