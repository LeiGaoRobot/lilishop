## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-25 - Avoid O(N²) String.contains in Streams/Loops
**Learning:** Checking for substrings using `String.contains()` on comma-separated lists within streams or loops is an O(N²) anti-pattern that can also cause subtle correctness bugs (partial matches).
**Action:** Always parse the comma-separated string into a `Set` (preferably `LinkedHashSet` to preserve order) BEFORE entering the stream or loop, allowing for safe O(1) lookups.
