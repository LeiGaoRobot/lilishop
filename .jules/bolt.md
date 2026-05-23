## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-23 - [O(N) String contains on delimited strings]
**Learning:** Found O(N) complexity and potential substring match bugs where `String.contains()` is used on a delimited string (e.g., `hours.contains("1")` matches "10") inside a stream filter.
**Action:** Always parse delimited strings into a `Set` (e.g., `HashSet`) outside loops/streams before checking inclusion to achieve O(1) lookup time and exact matching.
