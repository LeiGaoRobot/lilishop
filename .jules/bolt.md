## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-06-03 - [O(N^2) Anti-Pattern in Collection Filtering]
**Learning:** Found O(N^2) complexity in filtering logic where `List.contains()` is used inside a stream filter over a large collection. Using Arrays.asList from an array creates a List which has O(N) lookup time.
**Action:** Convert arrays or lists to a `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, particularly when filtering based on an array of IDs.
