## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-07-21 - [Optimize Loop Invariants and Collections]
**Learning:** Found O(N^2) anti-pattern inside loop with `String.split()` and `List.contains()`. Doing string manipulations or streaming over arrays inside loops causes excessive GC pressure and CPU overhead on every iteration.
**Action:** Always hoist invariant operations (e.g. `String.split()`) outside the loop and convert arrays/lists to a `Set` for O(1) lookup. When checking existence before adding, use `Set.add()` which performs both operations efficiently in O(1) time.
