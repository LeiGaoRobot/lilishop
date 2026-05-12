## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2023-10-27 - [String.split inside Stream Filters]
**Learning:** Checking `String.contains()` directly on comma-separated list Strings within stream filters (e.g. `seckill.getHours().contains(i.getTimeLine().toString())`) can cause logic bugs (e.g., matching "2" in "12,14") and incurs repeated String.contains operations across Stream elements.
**Action:** Always safely parse delimited strings into a `Set` (e.g. `HashSet<>(Arrays.asList(str.split(",")))`) *outside* of loops or stream processing to achieve exact O(1) matching.
