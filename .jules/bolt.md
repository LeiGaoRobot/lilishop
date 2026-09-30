## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-30 - Optimize O(n) String.contains() and List.contains() in SeckillApplyServiceImpl
**Learning:** Using `String.contains()` on a comma-separated string can cause subtle logic bugs (e.g., partial matches like `"10,12,14".contains("1")`). Also, `List.contains()` within a loop is an O(n^2) operation.
**Action:** Always parse delimited strings into a `Set` for O(1) lookups. Hoist `split()` operations out of loops. Replace `if(!list.contains(item)) list.add(item)` with `if(!set.add(item))` for single-pass existence check and insertion.
