## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-24 - Convert Delimited String and List.contains to Set for O(1) in SeckillApplyServiceImpl
**Learning:** Found O(N^2) anti-patterns where `String.contains()` was used to check if a specific delimited string value matched, which can lead to false positive substring matching, and `List.contains()` inside a loop. These caused excessive operations in the main seckill apply logic.
**Action:** Converted delimited strings to `Set` and initialized target `Set` collections prior to the loops to achieve O(1) lookup and `add` capabilities to dramatically boost application performance and ensure correctness.
