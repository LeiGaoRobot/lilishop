## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-05 - Avoid String.contains() with delimited strings
**Learning:** Using `String.contains()` to search inside comma-separated strings (like category IDs) introduces subtle bugs where a substring unexpectedly matches (e.g., searching for "5" matches "50"). Furthermore, performing this check within loops using Java Streams incurs a performance penalty due to repeated object creation and inefficient traversal.
**Action:** Always split delimited strings into a `Set` before the loop and use `Set.contains()` instead. This fixes the substring bug, prevents excessive garbage collection, and improves lookup performance to O(1).
