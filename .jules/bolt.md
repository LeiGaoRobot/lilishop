## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-25 - [Optimize List.contains with Set for Delimited Strings]
**Learning:** Found O(N^2) complexity anti-pattern in `SeckillApplyServiceImpl` where a comma-separated string (`seckill.getHours()`) was being checked inside a stream filter using `String.contains()`. This not only causes O(N) allocation per iteration due to missing `Set` conversion, but also risks false positive substring matches (e.g., "10" matches "1") when `CharSequenceUtil.contains()` or `String.contains()` are used on delimited strings.
**Action:** Always convert delimited strings to a `Set` (e.g., `HashSet`) outside the loop/stream before using `.contains()` to achieve safe, exact O(1) lookups and prevent unintended substring matching bugs.
