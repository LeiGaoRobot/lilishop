## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-11-20 - Hoisted O(1) Set initialization from O(n^2) filter
**Learning:** Found O(N^2) complexity in `SeckillApplyServiceImpl` where `seckill.getHours().contains()` was evaluated inside a stream filter across all items.
**Action:** When filtering streams or collections using a delimited string, explicitly split the string and convert it into a `Set` outside the loop/filter to ensure O(1) lookups per element instead of redundant string parsing and searching.
