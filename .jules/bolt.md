## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2023-10-27 - [O(N^2) Anti-Pattern in Loop Optimization]
**Learning:** Found O(N^2) complexity where `String.contains()` was used to check if a comma-separated string (`seckill.getHours()`) contained a specific ID (`i.getTimeLine().toString()`) inside a stream filter.
**Action:** Splitting a comma-separated string to build a `Set` (e.g. `hoursSet`) and using `.contains()` on the `Set` changes the complexity to O(1) for lookups and avoids partial matches bugs compared to `String.contains()`.
