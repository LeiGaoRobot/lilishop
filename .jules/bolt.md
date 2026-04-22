## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-04-22 - Optimize String.split and List.contains in SeckillApplyServiceImpl
**Learning:** Performing `String.split(",")` inside loops creates unnecessary object allocations and overhead on every iteration. Moreover, using `String.contains()` on comma-separated strings can cause incorrect substring matches, and `List.contains()` is O(n).
**Action:** Always hoist invariant `String.split` operations outside the loop, convert arrays to `Set`, and use `Set.contains()` and `Set.add()` for safe, exact O(1) lookups and insertions.
