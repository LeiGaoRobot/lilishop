## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2025-05-20 - Use O(1) Set lookups instead of String.contains for comma-separated IDs
**Learning:** Using `String.contains()` on comma-separated strings inside `filter()` streams causes a performance bottleneck O(N*M) and can lead to incorrect substring matches (e.g. matching "12" in "123").
**Action:** Convert delimited strings to `Set`s before entering loops or streams to achieve O(1) lookup and correct exact matching.
