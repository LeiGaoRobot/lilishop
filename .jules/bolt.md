## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-05 - Avoid String.contains on Delimited Strings Inside Loops/Streams
**Learning:** Using `String.contains()` on a comma-delimited string inside a loop or stream filter creates an O(N) lookup penalty on every iteration and can lead to unintended substring matching bugs (e.g., matching "1" when searching for "10").
**Action:** Always pre-process delimited strings (e.g., `hours.split(",")`) into a `Set` (e.g., `HashSet`) outside the loop or stream to guarantee O(1) lookup performance and exact string matching.
