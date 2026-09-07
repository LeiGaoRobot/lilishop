## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-07 - Optimize List.contains within loops using Set.add
**Learning:** Using `List.contains()` inside a loop creates an O(N²) bottleneck for large datasets. `Set.add()` can simultaneously check for existence and add the item in a single O(1) operation.
**Action:** When iterating over a collection and adding unique items to another collection, use a `Set` to track uniqueness, and combine it with a `List` if you need to maintain insertion order or preserve a method signature.
