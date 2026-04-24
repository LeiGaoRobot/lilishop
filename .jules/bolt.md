## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-04-24 - [Optimize Check-And-Insert and Hoist Invariants]
**Learning:** Checking for existence using `.contains()` then `.add()` requires two operations. Also, repeatedly splitting strings (`hours.split(",")`) or creating arrays/streams inside a loop creates O(N) allocation, CPU, and GC pressure.
**Action:** Use `Set.add()` which returns a boolean indicating if the item was newly added to do existence check and insertion safely in a single O(1) operation. Always hoist invariant operations (e.g., `split`) outside loops.
