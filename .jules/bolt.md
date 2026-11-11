## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-11-11 - [Optimize Set.add() for check and insertion]
**Learning:** Found redundant existence checks where `if (!list.contains(item)) list.add(item)` was used inside a loop, which causes O(N^2) complexity. We can combine existence check and insertion into a single O(1) operation using `Set.add(item)`. Also, string splitting (e.g. `hours.split(",")`) was unnecessarily performed inside the loop.
**Action:** Leverage `Set.add()` which returns a boolean indicating if the item was newly added. Move invariant operations like string splitting outside of loops to prevent redundant allocations.
