## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-08-16 - [False Positives in Delimited String Substring Matches]
**Learning:** Using `String.contains()` on comma-delimited string representations of collections (like `"1,12".contains("1")`) leads to subtle bugs due to substring matching false positives.
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.asList(str.split(",")).stream().collect(Collectors.toSet())`) before checking for existence, ensuring correct behavior and O(1) performance.
