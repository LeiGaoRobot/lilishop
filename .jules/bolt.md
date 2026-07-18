## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-07-18 - Optimized SeckillApplyServiceImpl
**Learning:** Replaced O(N) `List.contains` and `String.contains` inside loops with O(1) `Set.contains`. Handled comma-separated string check more robustly by splitting into a Set before the loop.
**Action:** Always identify O(N) lookup operations inside loops or `.filter()` streams and refactor to `Set` for O(1) performance.
