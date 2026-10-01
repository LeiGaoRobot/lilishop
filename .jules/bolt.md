## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-03-24 - Hoist Invariant String Splitting & Optimize Contains to Set
**Learning:** Found redundant string splitting (`hours.split(",")`) inside a loop during check operations, and O(N) list `.contains()` calls inside loops.
**Action:** Hoist invariant operations like string splitting outside loops, and always convert collections to `Set` (e.g., `HashSet`) for O(1) `contains` and combined `add`/`contains` checks before loops.
