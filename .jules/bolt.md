## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-04-05 - Hoist String Splitting and Arrays into Sets
**Learning:** O(N) lookup functions like `.contains()` or invariant operations like `string.split(",")` inside of for-loops or stream filters create significant CPU overhead and memory allocations. Also, delimited substrings parsed with `String.contains` may produce bugs with incorrect partial matches.
**Action:** Always parse delimited strings and Collections into `java.util.Set` instances (e.g. `HashSet`) outside of loops or streams before filtering, enabling exact matching and O(1) loop iterations.
