## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-18 - Optimize Loop Hoisting and List.contains to Set
**Learning:** In Spring Boot validation loops, String splitting and `List.contains()` result in redundant allocations and O(N^2) complexity.
**Action:** Always hoist constant operations like `String.split` outside of the loop and utilize `Set.contains()` or `Set.add()` to achieve O(1) performance.
