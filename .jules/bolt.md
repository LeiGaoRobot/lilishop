## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-10-06 - Avoid String.contains on Delimited Strings
**Learning:** Using `String.contains()` on delimited strings (e.g. `"10,12".contains("1")`) is a correctness bug waiting to happen due to partial substring matches. It is also O(N) when placed inside a loop or stream filter.
**Action:** Always parse delimited strings into a `Set` (e.g., `HashSet`) and use `Set.contains()` instead. This fixes the partial match bug and provides O(1) lookups.
