## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-10-03 - [O(1) HashSet lookup over String.contains]
**Learning:** Using `String.contains()` to search for existence in delimited strings (like `"id,name,value"`) inside loops causes O(N) overhead on every iteration and subtle bugs when partial strings match (e.g., `"goodsId".contains("id")`).
**Action:** Always parse delimited strings into a `HashSet` upfront for O(1) exact lookups, preventing partial match bugs and significantly speeding up field-level filtering inside loops.
