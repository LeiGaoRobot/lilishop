## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-06-05 - Hoist String splitting and use Set for O(1) lookups inside loops
**Learning:** O(N) operations like `List.contains`, `String.split`, and `Arrays.stream().anyMatch()` inside loops scale poorly and degrade performance due to O(N^2) complexity and redundant allocations per iteration.
**Action:** Always hoist invariant string splits out of loops, convert them to `Set`s, and leverage `Set.add()` which safely combines the existence check and insertion into a single O(1) operation.
