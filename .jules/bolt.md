## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-18 - [Hoist and Set Conversion for Delimited Strings]
**Learning:** Found redundant `String.split()` and `String.contains()` on comma-delimited strings occurring inside loops and stream filters (e.g., `seckill.getHours().contains()`). This causes unnecessary O(N) allocations and checks on every iteration.
**Action:** Hoist the splitting of delimited strings outside of loops and convert them into a `HashSet`. This enables O(1) lookups inside the loop or stream filter and avoids repetitive string parsing overhead.
