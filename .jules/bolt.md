## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2023-10-24 - [SeckillApplyServiceImpl]
**Learning:** Found O(N²) complexity in batch processing logic (`checkSeckillApplyList` and `updateSeckillApplyTime`) where `List.contains()` and `String.contains()` on comma-separated values are used inside loops/stream filters. Additionally, `String.contains()` on comma-separated numbers (e.g., "10,12".contains("1")) creates subtle partial matching bugs.
**Action:** Parse comma-separated strings into a `Set` (e.g. `HashSet`) before the loop/stream to ensure exact matching and achieve O(1) lookup time. Convert existence-check Lists to `Set`s as well.
