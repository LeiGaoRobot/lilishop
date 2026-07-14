## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-07-14 - Fix String.contains substring match bug and O(n) overhead
**Learning:** Using `String.contains()` on comma separated lists like "10,12" inside loops causes unintended substring matching bugs (e.g. `contains("0")` returns true) and performs O(n) overhead.
**Action:** Always split delimited strings into a `Set` (e.g., `HashSet`) before checking for element presence inside loops or stream filters to guarantee exact matching and O(1) performance.
