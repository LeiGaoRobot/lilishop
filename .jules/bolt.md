## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2023-11-02 - [O(N) Set Lookups over O(N^2) List Lookups]
**Learning:** Using `List.contains()` inside loop constructs, especially within Java Streams filters, introduces O(N^2) complexity. Using `Set.contains()` or adding items directly to a Set inside a loop provides an O(N) complexity overall, dramatically improving performance for batch processing operations.
**Action:** Parse collections or arrays to a `Set` before using them for lookups within loops or stream filters, and use `Set.add()` to avoid O(N) contains checks in loops.
