## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-06-01 - Optimize `String.contains()` inside loop in `SeckillApplyServiceImpl.java`
**Learning:** Checking for substrings inside loops using `String.contains()` on comma-delimited strings is dangerous (can result in partial matches leading to bugs) and inefficient (O(N) lookup time) when executed on every iteration inside a `.stream().filter()`.
**Action:** Always parse the comma-delimited string into a `Set<String>` (e.g. `HashSet`) outside the loop, enabling accurate exact matches and O(1) lookup time.
