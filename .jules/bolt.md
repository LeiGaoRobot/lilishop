## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2023-10-28 - [String Substring Match Bug]
**Learning:** Using `String.contains()` on comma-separated values (e.g., `hours.contains(timeLine)`) can cause subtle substring match bugs (e.g. searching for "1" matches "10").
**Action:** Always parse comma-separated strings into a `Set` or `List` before checking for membership to ensure exact matches.
