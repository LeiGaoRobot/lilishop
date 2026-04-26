## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g. `"6,10,14".contains("1")`) not only performs poorly in loops but also introduces bugs due to substring matching ("1" matches "10").
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.stream(str.split(",")).collect(Collectors.toSet())`) before filtering to ensure correctness and O(1) performance.

## 2024-05-19 - Fast iteration over large date lists
**Learning:** Using `stream().anyMatch()` for date comparisons inside loops creates significant closure and object allocation overhead, resulting in 100-200x slower execution times compared to a traditional for-loop when checking large collections. In this codebase, avoiding the stream API for hot loops improves performance measurably with negligible readability cost.
**Action:** Prefer traditional for-loops when iterating to find a matching object attribute (especially with `Date.before()`) over `.stream().anyMatch()` in critical performance paths.
