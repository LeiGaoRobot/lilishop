## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-24 - Optimize Invariant Operations inside Loops
**Learning:** Found string splitting `hours.split(",")` and `Stream.anyMatch` checks nested within a loop in `checkSeckillApplyList` validation logic. Also found an O(N) `List.contains` for duplicate checks.
**Action:** Hoisted string splitting out of loops and converted target arrays to `HashSet`s for O(1) membership lookups. Changed list duplicates checks to `Set.add()` which safely combines check and insertion in O(1) without overhead.
