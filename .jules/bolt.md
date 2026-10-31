## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-10-31 - [Optimize Loop Check with Set and pre-computation]
**Learning:** Avoid repeated array string splitting and `Stream.anyMatch` in a loop, as it generates unnecessary object overhead and O(N^2) complexity.
**Action:** Extract string split out of the loop into a Set for O(1) lookups. Additionally, replace List existence checks + additions (`if(list.contains) { ... } else { list.add() }`) with `Set.add()` which performs both in one O(1) step.
