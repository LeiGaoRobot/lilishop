## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-18 - Optimize nested loops and string lookups to O(1) Set
**Learning:** Using `String.contains` for delimited strings or nested loops inside stream filters causes an O(N) performance hit per iteration, scaling up to O(N²).
**Action:** Always extract comma-separated string splitting to a `HashSet` outside of loops or streams to achieve O(1) lookup time. Convert inner loop searches to `HashSet` lookups.
