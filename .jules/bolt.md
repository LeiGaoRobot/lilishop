## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-11-04 - Set Lookups for Dynamic Strings
**Learning:** Checking `String.contains()` on delimited strings during loop/stream filtering operations inside `SeckillApplyServiceImpl` runs in O(N^2) time since it traverses the list while performing sub-string search. It is also prone to correctness bugs via partial matches.
**Action:** Use `java.util.LinkedHashSet<>(java.util.Arrays.asList(delimitedString.split(",")))` parsed once before the filter block, then `set.contains()` inside the block to guarantee O(1) matching.
