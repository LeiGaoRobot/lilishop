## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-08-07 - Optimize List/Stream/String lookups to Set
**Learning:** Inside loops or Java streams, repeatedly calling `String.split()` or `.contains()` on a `List`/`String` causes excessive CPU and garbage collection overhead (O(N) or O(N^2)). Using `Set.add()` to simultaneously check existence and add an element is an O(1) single operation.
**Action:** Always hoist string parsing (like `.split()`) outside loops and convert reference collections to `HashSet` for O(1) lookups before entering loops or stream filters in performance-critical areas.
