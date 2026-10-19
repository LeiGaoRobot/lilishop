## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-10-18 - Optimize List.contains to Set and hoist operations outside loops
**Learning:** Using `List.contains` inside a loop results in an O(N²) time complexity. Additionally, repeatedly performing string splitting inside a loop causes redundant allocations and GC pressure.
**Action:** When performing exist checks inside loops, utilize a `Set` for O(1) lookups. Hoist redundant, loop-invariant operations like `hours.split(",")` outside the loop, parsing it directly into a `Set` for performance gains.
