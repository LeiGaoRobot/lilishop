## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-24 - O(N) Substring Match in Stream
**Learning:** Calling String.contains() directly inside a loop/stream to check if an item exists in a delimited string (e.g. comma separated path) performs an O(N) substring match for each iteration, and causes false positives if the target matches a partial token (e.g. matching "1" when it's part of "11").
**Action:** Always parse the delimited string into a Set<String> before the loop and use Set.contains() inside the loop. This changes lookup complexity to O(1) and ensures exact token matching.
