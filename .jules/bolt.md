## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-06-26 - Hoist expensive invariant split and Set conversion out of loops
**Learning:** The O(N) cost of string splitting `hours.split(",")` and Stream iterations `Arrays.stream().anyMatch()` inside loops causes unnecessary overhead and GC pressure for every element check.
**Action:** Always hoist invariant string splitting outside of loops, and convert arrays or lists to a `Set` (e.g., `HashSet`) *before* entering the loop to ensure O(1) lookup time during iteration. Use `Set.add()` for single step O(1) existence-check-and-insertion.
