## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-08-17 - Optimize List/String contain checks to Set in Loops
**Learning:** Checking existence in loops using `List.contains()` or `Stream.anyMatch()` against delimited strings creates O(N^2) overhead and risks substring matching bugs.
**Action:** Convert the reference collection or delimited string to a `Set` outside the loop to ensure O(1) lookup time and prevent partial matching bugs.
