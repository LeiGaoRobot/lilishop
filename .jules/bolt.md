## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-05-04 - O(1) Lookups and Invariant Hoisting in SeckillApplyList
**Learning:** In loops processing bulk data (like `seckillApplyList`), invariant operations such as string splitting and stream creations inside the loop cause O(N) allocation and CPU overhead. Using `List.contains()` for uniqueness checks results in an O(N²) anti-pattern.
**Action:** Always hoist invariant operations (e.g., `hours.split(",")`) outside loops. Convert string arrays or reference collections to `Set` (e.g., `HashSet`) beforehand to ensure correctness and achieve O(1) lookup time, especially when checking for uniqueness.
