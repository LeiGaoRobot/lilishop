## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-06-04 - [Optimize comma-separated string checks inside loops/streams]
**Learning:** Found O(N^2) complexity and correctness bug in `seckill.getHours().contains(i.getTimeLine().toString())` inside a stream filter. `getHours()` returns a comma-separated string, leading to O(N) regex/substring matching and potential false positives (e.g., matching "1" inside "12").
**Action:** Convert comma-separated string to a `Set` (e.g., `new HashSet<>(Arrays.asList(hours.split(",")))`) *before* the stream or loop to achieve O(1) lookup time and prevent substring matching bugs.
