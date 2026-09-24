## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-09-16 - O(N) lookup penalty with `CharSequenceUtil.contains` on delimited strings
**Learning:** Using `CharSequenceUtil.contains()` or `String.contains()` on comma-separated strings inside streams or loops introduces a subtle O(N) penalty (or worse, substring false positive issues) because it's equivalent to searching within a string. This can be especially harmful when checking coupon scope lists which can contain many categories or goods IDs, making the overall checking operation O(M * N) for M items and N scope elements.
**Action:** Always parse the comma-separated string into a `Set<String>` outside the loop/stream filter (or within the block if the outer is just if/else branch) and use `Set.contains()`. This transforms the string scanning O(N) into an O(1) hash map lookup, and prevents false positives when string IDs are substrings of each other.
