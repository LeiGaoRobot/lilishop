## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-18 - Avoid List.contains in Loops
**Learning:** In Java, using `List.contains()` inside a loop over delimited strings or large collections causes an O(N^2) time complexity, leading to unnecessary CPU overhead.
**Action:** Convert the collection to a `Set` (e.g., `HashSet`) for O(1) lookups before performing existence checks or insertions.
