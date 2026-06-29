## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-10-24 - Optimize delimited string contains to Set lookup
**Learning:** Using `String.contains()` on comma-delimited strings inside stream filters causes O(N) performance overhead per item and unintended substring matching bugs (e.g., "10,11,12" contains "1").
**Action:** Always convert delimited strings to a `Set` (e.g., `HashSet`) outside the loop or stream for O(1) lookups and strict exact matching.
