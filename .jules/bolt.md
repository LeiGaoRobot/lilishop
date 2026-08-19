## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-08-19 - Hoisting parsing outside loops and using Sets for existence checks
**Learning:** Parsing delimited strings (e.g. `String.split`) and using `List.contains` inside a loop or stream filter leads to O(N^2) complexity and redundant allocations. It can also cause unintended substring matching bugs if `String.contains` is used.
**Action:** Hoist the parsing logic (e.g., `split(",")`) outside the loop, and store the result in a `HashSet` to enable O(1) existence checks.
