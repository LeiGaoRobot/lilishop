## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-06-15 - [Optimize List.contains to Set for O(1) lookup and hoist loop invariants]
**Learning:** In `SeckillApplyServiceImpl.java`, checking existence within a `List` via `contains` and performing `String.split` inside loops create O(N^2) complexity and redundant processing.
**Action:** Hoisted the string splitting out of the loop and used `HashSet` for O(1) existence checks.
