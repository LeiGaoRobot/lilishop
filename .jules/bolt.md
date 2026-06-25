## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2025-06-25 - Avoid String.contains on Delimited Strings Inside Java Streams
**Learning:** Using `String.contains()` to search for an ID inside a comma-separated list of IDs is dangerous because it can match partial IDs (e.g., matching '123' inside '1234,5678'). Furthermore, parsing the comma-separated string inside a stream or loop is an expensive O(N) operation that applies on each iteration.
**Action:** Always parse delimited strings once outside of loops/streams, load them into a `Set` (e.g., `HashSet`), and use `.contains()` on the `Set` to provide accurate, O(1) matching.
