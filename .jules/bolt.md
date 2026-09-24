## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-11 - [String.contains vs Set.contains]
**Learning:** Found O(N^2) complexity in `SeckillApplyServiceImpl` where `String.contains()` was used to check delimited string existence inside a stream filter and where `List.contains` was used inside a loop check.
**Action:** Always hoist delimited string splitting and convert to `HashSet` for O(1) lookups before loops or stream operations. Use `Set.add()` instead of `List.contains()` + `List.add()` for O(1) existence checks inside loops.
