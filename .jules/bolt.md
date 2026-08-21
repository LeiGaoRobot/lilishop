## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-08-21 - Optimize O(N^2) loops with Sets
**Learning:** Found O(N^2) complexity in `SeckillApplyServiceImpl` where `List.contains` and `Stream.anyMatch` were used inside a loop against delimited strings that were split repeatedly. Using `String.contains` on delimited strings also risks unintended partial matches.
**Action:** Always convert reference collections or delimited strings to a `Set` before looping, and use `Set.add()` to combine existence checks and insertion into a single O(1) step.
