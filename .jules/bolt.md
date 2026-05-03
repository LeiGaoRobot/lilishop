## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-03 - Hoisting invariant string splitting and Stream allocations out of validation loops
**Learning:** Invalidation checks inside bulk operations frequently contain invariant operations, such as string splitting and Stream creations. These operations inside loops create substantial O(N) overhead in GC and CPU time.
**Action:** When validating a collection in a loop against a delimited string, parse the string into a Set outside the loop. Use `Set.contains` for fast O(1) checks. Also, replace `List.contains` with `Set.add` checks to combine lookup and insertion.
