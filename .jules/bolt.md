## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-08-20 - Set.add for exist+insert optimization
**Learning:** You can replace O(N²) list existence checks (`if (!list.contains(item)) { list.add(item); }`) with an O(1) set operation using `Set.add()`, which returns a boolean. If you still need the items in a List (e.g. for preserving an API signature), you can do `if (set.add(item)) { list.add(item); }` which achieves O(1) checks while maintaining the List without the O(N) contains lookup on every item.
**Action:** Apply `if (set.add(item)) { list.add(item); }` instead of `if (!list.contains(item)) { list.add(item); }` when refactoring O(N²) list insertion loops.
