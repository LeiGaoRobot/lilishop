## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-07-25 - Hoist String split and convert List to Set in loops
**Learning:** Found an O(N²) anti-pattern inside a loop where a String was repeatedly split and then sequentially searched using `Stream.anyMatch`, alongside a `List.contains` check for duplicate tracking. The repeated String splitting and Stream creation inside a loop causes excessive object allocation and CPU overhead, while `List.contains` adds O(N) lookup time.
**Action:** Always hoist invariant operations like String splitting outside of loops. Convert the resulting array to a Set for O(1) lookups. Additionally, replace List with a Set for existence checks and use `Set.add(item)` which returns a boolean to perform both the existence check and insertion safely in a single O(1) operation.
