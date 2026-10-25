## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-10-21 - [Optimize String.contains on Delimited Strings]
**Learning:** Using `String.contains()` on comma-separated values (e.g., `"10,12".contains("1")`) can lead to subtle bugs via partial matches, in addition to being O(N*M) performance when placed in a loop.
**Action:** Parse delimited strings into a `Set` outside the loop to achieve correct exact matches and constant O(1) lookup times.
