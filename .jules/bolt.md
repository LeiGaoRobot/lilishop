## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-09-19 - [O(N^2) Anti-Pattern in Collection Distinct Aggregation]
**Learning:** Found O(N^2) complexity in aggregation logic where `List.contains()` is used inside a loop to check for uniqueness before adding to a new list.
**Action:** Use a `Set` (e.g. `HashSet.add()`) to track and conditionally add elements instead of calling `.contains()` on a List when building distinct collections from a stream or list iteration, resulting in O(1) checks.
