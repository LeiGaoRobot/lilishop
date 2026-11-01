## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-11-01 - Avoid List.contains in Streams/Loops with Sets
**Learning:** Checking for element existence using `List.contains()` (or similarly partial matches with `String.contains()` on comma-separated values) inside streams, `for` loops, or `.filter()` operations can lead to subtle correctness bugs (e.g. "10,11,12".contains("1") is true) and creates O(N²) or O(N*M) performance bottlenecks on larger datasets.
**Action:** Always pre-parse the comma-separated or list-based collection into a `Set` (preferably `LinkedHashSet` if order matters) OUTSIDE the loop/stream, and use `Set.contains()` inside the loop for safe, accurate O(1) lookups.
