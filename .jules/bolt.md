## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-08-30 - Maintain Insertion Order When Optimizing List.contains to Set
**Learning:** When refactoring O(N) `List.contains` checks to O(1) `Set` lookups (e.g., in parameter parsing loops), using a standard `HashSet` may silently introduce subtle bugs if the downstream logic relies on the original insertion order of the elements.
**Action:** Always prefer `LinkedHashSet` over `HashSet` when substituting `List` with `Set` for performance in loops, unless you can definitively prove that order is irrelevant to all downstream consumers.
