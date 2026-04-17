## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2023-11-09 - [Substring Matching Bug in Delimited Strings]
**Learning:** Using `String.contains()` to check for the existence of an item in a delimited string (e.g., checking if "6,8,12" contains "1") leads to a subtle bug where substring matches are incorrectly identified as true.
**Action:** Always parse the delimited string into an exact `List` or `Set` of items (e.g., `Arrays.asList(str.split(","))`) and use the `contains()` method on the collection to guarantee exact item matching.
