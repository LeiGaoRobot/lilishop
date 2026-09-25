## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-08 - Optimize O(N^2) list contains in SeckillApplyServiceImpl
**Learning:** Found an O(N^2) pattern in `SeckillApplyServiceImpl` where a string is repeatedly split into a list, and then `List.contains()` is called in a loop. Moving the split outside the loop and changing the `existSku` list to a `Set` makes lookups O(1), saving CPU time and GC allocations.
**Action:** Always scan for redundant string splitting and `List.contains()` checks within loops. Precompute to arrays/lists, and convert `List` to `Set` for O(1) existence checks.
