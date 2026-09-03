## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-03-22 - [Avoid String.contains on Delimited Strings]
**Learning:** Using `String.contains()` on comma-delimited strings in stream filters inside loops causes O(N) lookup time overhead per element and introduces subtle substring matching bugs (e.g., "12".contains("2") is true).
**Action:** Always parse delimited strings and convert them into a `Set` prior to stream operations to achieve O(1) lookup time and exact matching.
