## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-04-18 - [O(N^2) Loop Optimization via Set and Hoisting]
**Learning:** Found multiple expensive operations occurring inside loops, including `ArrayList.contains()` resulting in O(N^2) and invariant operations like `String.split()` causing unnecessary allocations on every iteration in `SeckillApplyServiceImpl`. `String.contains()` was also used for comma-separated items inside a stream, creating O(N) processing plus a potential subtle bug on substring matching.
**Action:** Always hoist invariant splits/conversions outside of loops or streams. Convert collections or delimited strings into a `Set` (e.g., `HashSet`) to perform fast O(1) matching checks. Use `Set.add()` to do combined existence check and insertion safely in a single operation.
