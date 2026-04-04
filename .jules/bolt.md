## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-04-04 - [O(N) operations inside loop]
**Learning:** Found string splitting and stream creation inside a loop, causing unnecessary overhead.
**Action:** Hoist invariant operations like string splitting outside the loop and convert arrays to `Set` for O(1) lookup inside the loop.
