## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-24 - Avoid `String.contains()` on comma-separated values in Streams
**Learning:** Using `String.contains()` to search for an element within a delimited string (e.g., `"10,12,14".contains("1")`) can cause subtle correctness bugs due to partial substring matches and degrades performance with an O(N) lookup. Inside a `.filter()` on a Java Stream, this O(N) check runs per element, resulting in unnecessary O(N^2) complexity and object creation.
**Action:** Parse the delimited string into a `java.util.Set` (preferably `LinkedHashSet` to maintain insertion order if relevant) before entering the loop or stream. This fixes the substring matching bug and provides safe O(1) lookup performance.
