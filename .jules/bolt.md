## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-04-13 - O(1) Lookups for delimited strings
**Learning:** Checking for substrings within a comma-separated string using `String.contains()` inside loops or stream filters is an O(N) operation and can introduce unintended substring matching bugs (e.g., matching "12" in "123").
**Action:** Always convert comma-separated strings to a `Set` before the loop or stream operation to achieve O(1) lookup time and prevent substring bugs.
