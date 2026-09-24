## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-12 - [Optimized String Split and Contains in SeckillApplyServiceImpl]
**Learning:** Found O(N²) complexity in batch processing logic where `String.split()` and `List.contains()` were used repeatedly inside a loop checking time overlaps and deduplicating SKUs.
**Action:** Always hoist invariant operations like `String.split()` outside of loops and convert target elements/arrays into `Set` to enable O(1) lookups during iteration.
