## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-10-28 - Optimize String.contains for List Filtering
**Learning:** Using `String.contains()` to perform substring matching inside stream `.filter()` loops, especially on comma-separated list of IDs like `"1,2,11".contains(id)`, can result in a subtle O(N) correctness bug when attempting to match "1" inside "11".
**Action:** Convert delimited strings into `LinkedHashSet` structures outside loop operations to guarantee O(1) matching time, avoid accidental partial substring matches, and maintain order.
