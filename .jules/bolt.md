## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g. `"6,10,14".contains("1")`) not only performs poorly in loops but also introduces bugs due to substring matching ("1" matches "10").
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.stream(str.split(",")).collect(Collectors.toSet())`) before filtering to ensure correctness and O(1) performance.
## 2024-04-22 - Optimize String.split and List.contains in SeckillApplyServiceImpl
**Learning:** Performing `String.split(",")` inside loops creates unnecessary object allocations and overhead on every iteration. Moreover, using `String.contains()` on comma-separated strings can cause incorrect substring matches, and `List.contains()` is O(n).
**Action:** Always hoist invariant `String.split` operations outside the loop, convert arrays to `Set`, and use `Set.contains()` and `Set.add()` for safe, exact O(1) lookups and insertions.
