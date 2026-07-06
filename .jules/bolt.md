## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-07-06 - Prevent Substring Matching Bugs and O(N) allocation on Delimited Strings
**Learning:** Using `String.contains()` to search for an ID inside a comma-delimited string (e.g., `seckill.getHours().contains(id)`) can cause subtle substring matching bugs (e.g., searching for "1" matches "10"). Doing this inside a stream filter also causes unnecessary overhead.
**Action:** Hoist the processing of the delimited string out of the loop/stream into a `Set` (e.g., `Set<String> set = new HashSet<>(Arrays.asList(str.split(",")))`) and use `set.contains()` to achieve safe, O(1) membership lookups.
