## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-18 - String contains vs Set lookup in frequent loops
**Learning:** Using String.contains() on a delimited string inside a loop results in implicit O(N) searching for each iteration. Converting a fixed delimited string array to a Set once reduces this to an O(1) lookup.
**Action:** When a delimited string is used repeatedly with .contains() inside a loop or frequent method (e.g., in Elasticsearch index updating), parse it into a static final java.util.Set for fast O(1) lookups.
