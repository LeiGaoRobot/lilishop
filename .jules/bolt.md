## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-08-06 - Optimize List.contains inside stream filter/loop
**Learning:** Found O(N^2) complexity in `SeckillApplyServiceImpl` where `List.contains()` is used inside a loop over a large collection, and a redundant `String.split(",")` inside the loop.
**Action:** Hoist invariant string split operations outside the loop, and convert lists to `Set` (e.g., `HashSet`) before using `.contains()` to achieve O(1) lookup time, especially in critical paths.
