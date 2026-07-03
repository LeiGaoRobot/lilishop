## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-03 - [Optimize List.contains to Set for Seckill Hours]
**Learning:** Found O(N * M) complexity inside `SeckillApplyServiceImpl.updateSeckillApplyTime` where `seckill.getHours().contains(i.getTimeLine().toString())` was repeatedly splitting a comma-separated string `hours` and performing linear lookups for each item in a stream filter.
**Action:** Always parse comma-separated strings (like `hours`) into a `Set<String>` before using `.contains()` within loops or stream filters to achieve O(1) lookup time, reducing the complexity to O(N) and eliminating redundant string parsing.
