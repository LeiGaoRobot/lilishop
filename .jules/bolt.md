## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-22 - Optimize String.contains() and List.contains() in loops to Set
**Learning:** Using `String.contains()` on comma-separated strings inside streams or loops is an O(N^2) anti-pattern that can cause unintended substring matches and poor performance. The same applies to `List.contains()` in loops.
**Action:** Always parse comma-separated strings into a `Set` (e.g., `HashSet`) outside the loop or stream to achieve safe, O(1) exact matching. Use `Set.add()` for O(1) existence checks while inserting elements.
