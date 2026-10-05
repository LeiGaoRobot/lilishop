## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-10-05 - Optimize List.contains to Set inside loops
**Learning:** Checking for substrings or containing items in string delimited arrays inside loops or Java streams with `.contains()` creates O(N^2) time complexity and redundant allocations per iteration. In addition, using `String.contains()` on delimited strings can cause partial matching bugs (e.g., `"10,12,14".contains("1")`).
**Action:** Always parse comma-delimited strings into a `Set` outside of the loops or streams to achieve O(1) lookups and guarantee exact matching correctness.
