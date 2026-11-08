## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-11-08 - [O(N^2) Anti-Pattern with String contains on delimited strings]
**Learning:** Using `String.contains()` on delimited strings inside loops (e.g., `seckill.getHours().contains(...)`) introduces an O(N^2) performance bottleneck and risks subtle correctness bugs from partial string matches (e.g., matching "1" inside "10,12,14").
**Action:** Parse delimited strings into a `Set` (e.g., `LinkedHashSet`) prior to looping. This achieves O(1) lookup time and ensures exact token matching without risking partial substrings.
