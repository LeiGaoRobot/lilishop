## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-10 - [Loop Invariant Optimization]
**Learning:** Found redundant split and anyMatch loops inside a validation loop checking if a user provided timeline hour matches allowed separated string of hours (`String.split`).
**Action:** Always hoist invariant string manipulations (like `split`) out of loops and load them into a `HashSet` before the loop. This converts a nested O(N) match on string arrays into a single O(1) hash check.
