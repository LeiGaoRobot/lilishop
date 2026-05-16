## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-16 - Prevent substring match bugs and improve performance with O(1) lookups
**Learning:** Checking existence in delimited strings using `String.contains()` inside stream filters or loops causes O(N*M) overhead and substring matching bugs.
**Action:** Always parse delimited strings into a `Set` before loops/streams to ensure O(1) lookups and correctness.
