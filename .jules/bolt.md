## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings and List.contains() in loops]
**Learning:** Using `String.contains()` on comma-delimited strings introduces bugs due to substring matching ("1" matches "10"). Furthermore, performing `String.split(",")` and `List.contains()` (O(N)) inside loops causes significant overhead.
**Action:** Always hoist invariant `String.split` operations outside the loop, parse delimited strings into a `Set` for exact matching, and use `Set.contains()` and `Set.add()` to achieve O(1) performance and correctness.
