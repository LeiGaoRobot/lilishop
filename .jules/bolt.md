## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-11-05 - Optimize List.contains to Set for O(1) Lookups
**Learning:** Using `List.contains()` or `String.contains()` on delimited strings inside loops or stream filters introduces O(N^2) anti-patterns and can cause subtle correctness bugs (e.g., partial matches).
**Action:** Always parse delimited strings into a `Set` (prefer `LinkedHashSet` if insertion order matters) before loops, and replace `List` with `Set` when performing existence checks.
