## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-06-12 - Hoisting Loop-Invariant Operations and Collection Types
**Learning:** Checking existence in loops using `List.contains()` results in O(N²) complexity. Repeating string parsing (`String.split()`) and stream allocations (`Arrays.stream()`) within a loop causes excessive GC pressure and CPU overhead.
**Action:** Always hoist invariant object allocations and string splitting outside of loops. Convert collections to `Set` for O(1) existence checks inside loops, and utilize `Set.add()` for atomic add-and-check operations.
