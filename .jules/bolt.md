## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-04-06 - Hoist Invariant Logic & Avoid O(N^2) Contains
**Learning:** In loops, splitting strings and creating streams inside the loop leads to redundant object allocation. In addition, using `List.contains` for tracking existences inside loops turns into an O(N^2) performance bottleneck.
**Action:** Hoist the string `split` operations and `HashSet` creation outside loops to avoid allocating on each iteration. Convert collections like `existSku` to a `Set` and use `Set.add()` which runs in O(1) time while checking for duplicates.
