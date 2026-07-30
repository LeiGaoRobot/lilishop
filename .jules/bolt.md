## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2023-10-27 - [Hoisting string parsing outside of loops]
**Learning:** Found repetitive array creation from `String.split(",")` inside loops handling batch processing. Also found an O(N) lookup (`List.contains()`) followed by `List.add()`.
**Action:** Always hoist string parsing (`split`) outside of iterations and use a single `Set.add()` which returns a boolean indicating existence, turning O(N) operations into O(1) and reducing GC pressure.
