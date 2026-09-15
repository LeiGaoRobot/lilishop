## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-09-15 - [Optimize List.contains to Set for SeckillApply Hours]
**Learning:** Checking for elements in a small array or string splitting in a loop using `contains` creates O(N) lookup operations and redundant object allocations. When the outer loop iterates over a potentially large list of items (e.g. `SeckillApply` entities) and repeatedly calls `.contains()` on a comma-separated string, performance degrades.
**Action:** Parse the comma-separated string to a `Set<String>` *once* outside the loop to reduce string manipulation overhead and achieve O(1) lookup times.
