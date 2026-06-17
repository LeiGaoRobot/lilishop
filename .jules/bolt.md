## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-06-17 - Hoist List-to-Set Conversion out of Loops for O(1) Lookups
**Learning:** Checking `List.contains(item)` or repeating `string.split()` inside a loop causes hidden O(N²) iteration complexity and high GC pressure due to redundant allocations.
**Action:** When a loop contains multiple `.contains()` checks against fixed lists or delimited strings, hoist the conversion logic outside the loop using `new HashSet<>(Arrays.asList(string.split(",")))` to achieve safe O(1) lookups and significantly reduce loop overhead.
