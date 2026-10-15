## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-10-11 - [Optimize String.contains in Stream Filters]
**Learning:** Found O(N*M) complexity where `String.contains()` is used inside a stream filter over a large collection, specifically on a comma-separated string of hours in `SeckillApplyServiceImpl`.
**Action:** Always parse comma-separated strings into a `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time.
