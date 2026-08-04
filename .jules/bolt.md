## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-08-04 - Optimize List.contains to Set and hoist invariants in loops
**Learning:** Using `List.contains()` inside a loop, as well as redundant string splitting and Array/Stream creation (e.g. `hours.split(",")` and `Arrays.stream().anyMatch()`), creates an O(N²) bottleneck and excessive memory allocation during high-traffic seckill operations.
**Action:** Always hoist invariant operations (like parsing a fixed list of hours) outside of the loop, convert them to a `Set`, and change collections used for presence checks inside loops from `List` to `Set` to leverage O(1) lookup. Furthermore, use `Set.add()` to do both presence checking and insertion in a single operation.
