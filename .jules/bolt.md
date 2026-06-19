## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-06-19 - [Hoist Invariant Array Allocation and Streaming Out of Loops]
**Learning:** Found redundant array allocation (`split`) and stream creation (`Arrays.stream`) inside a loop for invariant variables, causing unnecessary O(N) CPU overhead and garbage collection pressure.
**Action:** Always hoist invariant operations outside of loops and switch statements to avoid repeated allocations and redundant work.
