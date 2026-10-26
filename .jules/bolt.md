## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-10-26 - Prevent subtle bugs and optimize lookups with Set conversion
**Learning:** Using `String.contains()` on comma-separated strings inside streams can cause subtle correctness bugs (e.g., `"10,12,14".contains("1")` returns true). It is also an O(N) operation per element, creating an O(N²) anti-pattern inside loops or stream filters.
**Action:** Always parse delimited strings into a `LinkedHashSet` outside the loop/stream. This guarantees correctness by preventing partial substring matches, ensures O(1) lookup time, and preserves insertion order.
