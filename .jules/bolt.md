## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-10-24 - String.contains() on delimited strings can cause subtle correctness bugs
**Learning:** Using `String.contains()` on a comma-separated list of IDs (e.g. `"10,12,14".contains("1")`) can result in partial matches.
**Action:** Always parse delimited strings into a `Set` (e.g., `new LinkedHashSet<>(Arrays.asList(str.split(",")))`) before checking for containment to ensure correctness and achieve O(1) lookup performance.
