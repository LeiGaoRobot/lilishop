## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-05-17 - [Optimize O(N^2) Validation in Seckill]
**Learning:** Validations inside loops containing string splitting and list-based existence checks create unintended O(N^2) bottlenecks when processing batches of promotions.
**Action:** Always hoist invariant splits outside the loop and convert arrays/lists to Sets (e.g., HashSet) to ensure O(1) lookups during validations.
