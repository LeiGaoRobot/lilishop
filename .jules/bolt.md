## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-24 - Hoist invariant operations and use Set for lookup inside loops
**Learning:** Moving redundant operations like `String.split` and `Arrays.stream` out of loops avoids significant overhead, and replacing `List.contains` with `Set.add` transforms O(N^2) complexity to O(N).
**Action:** When validating lists against configuration or checking for uniqueness within a loop, initialize a `Set` outside the loop to handle lookups and uniqueness checks in O(1) time.
