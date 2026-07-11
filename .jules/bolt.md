## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-10 - O(N²) List.contains Anti-pattern in loops
**Learning:** Found instances of `List.contains()` and `Stream.anyMatch()` inside loops which create an O(N²) performance bottleneck during bulk operations.
**Action:** Always convert the reference collection or delimited string to a `Set` (e.g., `HashSet`) outside the loop to ensure O(1) lookup time.
