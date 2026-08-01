## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-08-01 - [String.contains Bug Masked as Performance Issue]
**Learning:** Using `String.contains()` to check if a comma-separated list of IDs contains a specific ID can lead to logical substring matching bugs (e.g., "10,12".contains("1") is true). Additionally, doing this split/search inside a loop causes O(N²) complexity.
**Action:** Always parse delimited strings into a `Set` (e.g., `HashSet`) outside the loop. This provides O(1) exact-match lookups, simultaneously fixing the substring bug and eliminating the O(N²) performance bottleneck. Furthermore, `Set.add()` can be used to perform both the existence check and insertion safely in a single O(1) operation.
