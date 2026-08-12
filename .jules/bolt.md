## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-08-12 - [Optimize O(N) List.contains and String matching to O(1) Set]
**Learning:** String.contains on delimited strings causes substring matching bugs (e.g. searching for "1" matches "12"). Using List.contains in loops causes O(N) lookup performance degradation.
**Action:** Always parse delimited strings into a Set for exact O(1) matching. Hoist invariant operations outside of loops and use Set.add() instead of List.contains() for O(1) performance existence checks.
