## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-06-28 - Optimize List.contains to Set in SeckillApplyServiceImpl
**Learning:** Found O(N²) and invariant anti-patterns in SeckillApplyServiceImpl where delimited strings were unnecessarily split inside loops and `.contains()` checks were performed.
**Action:** Replaced String.split and List.contains with Set.contains by hoisting the string splitting and Set creation operations outside loops, ensuring O(1) performance and removing unnecessary inner-loop object allocation.
