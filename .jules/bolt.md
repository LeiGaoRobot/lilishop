## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-10-22 - Optimize delimited string checks with Set
**Learning:** Checking if a comma-separated string contains a substring (e.g. `"6,8,12".contains(target)`) using `String.contains()` inside a loop over database results can cause subtle partial match bugs (e.g. "12".contains("1") is true) and results in O(n) performance.
**Action:** Parse the delimited string into a `Set` (e.g. `LinkedHashSet` to preserve order) using `Arrays.asList(str.split(","))` before the loop to guarantee O(1) lookup time and prevent partial match bugs.
