## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-05 - Optimize List.contains inside loops
**Learning:** Checking for existence using `List.contains` inside a loop leads to O(N^2) complexity, causing performance bottlenecks for large collections. Hoisting invariant operations like `split()` out of loops also improves efficiency.
**Action:** Always convert Collections or Arrays to `Set`s before using `.contains` inside loops for O(1) lookups, and hoist expensive invariant operations before the loop.
