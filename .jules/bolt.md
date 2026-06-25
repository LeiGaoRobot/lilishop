## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-05-26 - [Delimited String Substring Bugs and O(N) Loop Invariants]
**Learning:** Found O(N) substring matching issues in stream filters (e.g., `String.contains()` matching "1" inside "10,12") and expensive loop invariants (e.g., `String.split()`) inside O(N) loops. Also learned that `Set.add()` can cleanly replace `if(!existSku.contains()) existSku.add()` inside loops for O(1) duplicate checking.
**Action:** Always parse delimited strings into a `Set` for exact, O(1) matching. Hoist loop invariants out of O(N) blocks. Utilize `Set.add()` for clean, single-pass O(1) deduplication.
