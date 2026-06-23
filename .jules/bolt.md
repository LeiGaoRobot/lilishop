## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-06-18 - Optimize checkSeckillApplyList with Sets and Hoisting
**Learning:** Found an O(N^2) anti-pattern where a comma-separated string (`hours`) was being split and converted to a stream to perform a linear search (`anyMatch`) inside a loop over a list. A `List.contains()` check was also used for uniqueness.
**Action:** Always hoist invariant string parsing/splitting outside of loops. Convert the resulting array to a `HashSet` to enable O(1) lookups instead of O(N) stream iterations. Replace `List.contains()` checks for duplicate detection with `Set.add()`, which simultaneously checks for existence and inserts the element in a single O(1) operation.
