## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-05-28 - Avoid String substring matching bugs inside stream filters
**Learning:** Using `String.contains()` on delimited strings (e.g., `seckill.getHours().contains(id)`) inside stream filters or loops is an O(N) performance anti-pattern and introduces severe correctness bugs due to unintended substring matching (e.g., matching "1" inside "12").
**Action:** Always convert comma-separated or delimited strings into a `Set<String>` outside the stream or loop to achieve safe, accurate O(1) lookups.
