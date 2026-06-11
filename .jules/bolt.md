## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2023-11-09 - [Hoisted O(1) Set lookup from comma-delimited strings]
**Learning:** Checking `delimitedString.contains()` inside a stream filter or loop operates in O(N^2) and may erroneously match substrings if the delimited string logic doesn't align correctly.
**Action:** When a delimited string is used for lookups in a collection loop/stream, always split and convert the string into a `HashSet` outside the loop, handling nulls with `Collections.emptySet()`, to ensure O(1) exact matching.
