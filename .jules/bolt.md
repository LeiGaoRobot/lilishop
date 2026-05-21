## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-21 - [Avoid String.contains for Delimited Lists in Loops]
**Learning:** Using `String.contains()` to check if a numeric ID or time exists in a comma-separated string (e.g., `"6,8,12".contains("1")`) not only runs in O(N) but also causes logical bugs via partial substring matching.
**Action:** Always split delimited strings into a `Set<String>` outside of loops/streams for safe, O(1) exact matching.
