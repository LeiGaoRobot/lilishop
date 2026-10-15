## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-09-28 - Optimize List.contains to Set for O(1) Lookups in SeckillApplyServiceImpl
**Learning:** Using `List.contains()` inside loops causes O(N²) performance overhead. In Java, this is especially pronounced when checking presence over thousands of iterations.
**Action:** Hoist the collection construction outside the loop and convert lists to sets to ensure O(1) lookup times and resolve the bottleneck.
