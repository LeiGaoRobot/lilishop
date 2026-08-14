## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-08-14 - Optimize List.contains to Set for Seckill hours and skus
**Learning:** Checking existence in loops or using stream `anyMatch` over strings split into Arrays causes O(N²) complexity and unnecessary object allocations. In `SeckillApplyServiceImpl.checkSeckillApplyList`, splitting a comma-separated `hours` string in every loop iteration and checking `existSku.contains()` on an ArrayList are both inefficient patterns.
**Action:** Lift static array conversions out of loops and use `Set.contains()` and `Set.add()` to simultaneously verify and enforce uniqueness and existence with O(1) complexity, reducing redundant string splitting and loop iteration overhead.
