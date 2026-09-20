## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-03-20 - [O(N^2) Anti-Pattern in Collection Membership Checks within Loops]
**Learning:** Found O(N^2) complexity in loop processing logic where `List.contains()` is used inside a loop over a large collection (e.g., `checkSeckillApplyList`).
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` or use `Set.add()` to simultaneously insert and check membership to achieve O(1) time complexity within loops.
