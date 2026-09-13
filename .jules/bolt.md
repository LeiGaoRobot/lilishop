## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-13 - Hoist Delimited String Splitting Outside Loops/Filters
**Learning:** Checking for substrings directly on a comma-delimited string (e.g., `hours.contains(...)`) inside loops or `.filter()` streams creates redundant string evaluations, O(N) lookups, and allocation overhead per element.
**Action:** When a delimited string is checked multiple times, strictly split it into an array and initialize a `HashSet` *before* the loop or stream. Use the `HashSet.contains()` method to achieve an O(1) complexity lookup while preventing redundant garbage collection overhead from repeated split actions.
