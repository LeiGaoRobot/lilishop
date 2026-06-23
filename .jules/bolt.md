## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-06-22 - Optimize List.contains to Set in Loops
**Learning:** Using `ArrayList.contains()` inside a loop, especially nested ones like when iterating over user menus to aggregate string-based permissions, introduces an O(N^2) time complexity. This is particularly wasteful when we just need deduplicated tracking of strings.
**Action:** Always prefer `java.util.LinkedHashSet` for existence checks and maintaining unique collections when insertion order is required, as its `.contains()` check runs in O(1). Convert back to `ArrayList` at the end if the method signature dictates returning a List.
