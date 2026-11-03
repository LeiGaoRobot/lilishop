## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-11-03 - Optimize loop duplicate check using Set
**Learning:** Checking `List.contains()` on an accumulator list inside a loop creates an O(N²) operation.
**Action:** When accumulating unique items in a loop and checking for duplicates, use a `Set` instead of a `List` and leverage the boolean return value of `Set.add()` to perform the check and insertion in a single O(1) operation.
