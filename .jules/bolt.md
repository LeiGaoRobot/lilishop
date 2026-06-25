## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-06-13 - [Performance] Optimize delimited string contains and loop existence checks
**Learning:** Using `String.contains()` on comma-separated strings inside a stream filter causes O(N) string scanning and can lead to accidental substring matching bugs (e.g., "12" containing "1"). Furthermore, using `List.contains()` inside loops leads to O(N^2) complexity.
**Action:** Always convert delimited strings to a `Set<String>` before stream processing for O(1) exact match lookups. Hoist invariant operations like `split()` outside loops. Replace `List<String>` with `Set<String>` for collection existence checks, and leverage `Set.add()` which performs both the existence check and insertion safely in a single O(1) operation.
