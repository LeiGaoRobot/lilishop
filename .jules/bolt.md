## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-11-09 - [Preventing partial match correctness bugs via O(1) Sets]
**Learning:** Found multiple instances where comma-separated strings (like `areaId` or `scopeId`) were directly checked using `String.contains()` inside a loop. This is not only inefficient but can also cause subtle correctness bugs due to partial matches (e.g., `"10,12,14".contains("1")` returning true).
**Action:** Always parse delimited strings into a `Set` before using `.contains()` inside a loop to guarantee exact matching and O(1) lookups.
