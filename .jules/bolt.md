## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-06-16 - Optimize List.contains to Set in SeckillApplyServiceImpl
**Learning:** Checking for element existence in a collection (`List.contains()`) inside a loop results in O(N^2) time complexity and checking for element existence in a delimited string by splitting and then filtering is similarly inefficient. Replacing lists with `HashSet` for O(1) lookups inside loops significantly mitigates O(N) allocation, GC pressure, and CPU overhead on every iteration.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
