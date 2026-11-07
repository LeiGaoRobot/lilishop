## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2025-01-22 - [O(N^2) bottlenecks in Array Splitting and List Contains]
**Learning:** Found O(N^2) complexity in batch processing logic where `hours.split(",")` and `List.contains()` are used inside a loop over a large collection in `SeckillApplyServiceImpl`.
**Action:** Always pre-split strings into a `Set` (e.g., `HashSet`) outside the loop and use `Set.add()` for O(1) lookup and insertion time, especially for bulk operations.
