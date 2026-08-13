## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2023-10-27 - [Hoist operations and Set for O(1) checks]
**Learning:** Found redundant string splitting (`String.split`) and O(N) stream `anyMatch` and list `contains` operations inside a loop iterating over batch processing (`checkSeckillApplyList`).
**Action:** Hoist the string splitting and convert the result to a `Set` outside the loop to avoid redundant operations and allocations. Use `Set.contains()` for O(1) lookup, and use `Set.add()` for safe and concise O(1) existence checks.
