## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-30 - O(N) Loop Invariants and Set Lookups
**Learning:** Using `List.contains` inside a loop results in an O(N²) time complexity. Also, calling `String.split` on every iteration of a loop creates redundant allocations. Using `String.contains` for delimited string matching can cause unintended substring match bugs (e.g. matching "12" in "1,12,3" instead of matching exact elements).
**Action:** Hoist invariant operations like `String.split` outside the loop, convert the array to a `Set` for O(1) lookups, and use `Set.add()` to simultaneously check existence and add items inside loops.
