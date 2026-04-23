## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-04-23 - [Substring Matching Bug and O(N) Anti-Pattern on Delimited Strings]
**Learning:** Using `String.contains()` to search for an element within a delimited string (e.g., searching for "1" in "12,14") can cause unintended substring matches and executes in O(N) time inside a loop/stream.
**Action:** Always split the delimited string and convert it to a `Set` (e.g., `HashSet`) before the loop/stream filter to achieve O(1) lookup time and ensure exact element matching.
