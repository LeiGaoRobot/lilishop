## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-04 - [String.contains() Anti-Pattern on Delimited Strings]
**Learning:** Using `String.contains()` directly on a comma-separated string inside a loop or stream filter (e.g., `seckill.getHours().contains(timeLine)`) causes unintended substring matching bugs and O(N) allocation overhead per iteration.
**Action:** Always parse delimited strings into a `Set` (e.g., `new HashSet<>(Arrays.asList(str.split(",")))`) prior to the loop to ensure safe, exact O(1) matching and avoid excessive string manipulation overhead.
