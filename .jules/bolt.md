## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-07-02 - Optimize String.contains on Delimited Strings
**Learning:** Using `String.contains()` on comma-separated values (like "6,8,12") inside stream filters causes both unintended substring matches (e.g., checking for "1" matches "12") and O(N) traversal overhead inside a stream filter.
**Action:** Always parse the delimited string into a `Set` before the loop/stream for O(1), exact string matching.
