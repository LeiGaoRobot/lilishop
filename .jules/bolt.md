## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-04-29 - String Substring Bugs and Redundant Allocations
**Learning:** Using String.contains() on comma-delimited string fields (e.g., "10,12,18".contains("1")) matches unintended substrings, causing logic bugs. Furthermore, splitting strings and searching lists inside loops causes O(N^2) overhead.
**Action:** Convert delimited strings to HashSets before the loop or stream for exact matching and O(1) lookups, fixing the bug and improving performance.
