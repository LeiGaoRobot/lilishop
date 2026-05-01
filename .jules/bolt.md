## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-04-30 - [Optimize Substring Contains in Streams]
**Learning:** Using `String.contains()` or `CharSequenceUtil.contains()` to search for IDs inside comma-separated strings during stream filtering is an O(N^2) anti-pattern. This also leads to unintended substring matching bugs (e.g., matching "12" against "112,13").
**Action:** Always hoist the parsing of the delimited string into a `Set<String>` before the loop/stream filter for O(1) exact matches and correct semantics.
