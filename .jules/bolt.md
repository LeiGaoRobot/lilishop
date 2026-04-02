## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-04-02 - [Optimize String.contains inside loop]
**Learning:** [Using String.contains() for delimited strings inside loops/streams has O(N) lookup and substring match bugs. Converting to a HashSet beforehand solves both issues.]
**Action:** [Always convert delimited string fields to Set before loop iterations]
