## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-24 - Avoid O(N) contains checks in Java Streams
**Learning:** Checking existence in a list inside a loop or Stream `.filter()` using `list.contains()` leads to O(N²) time complexity. Using `Set.contains()` optimizes this to O(N) by reducing the check to O(1).
**Action:** Always convert standard collections like arrays or `List` to a `Set` before using them as a reference in `contains()` queries within loops or stream filters to dramatically improve performance.
