## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-06-25 - Avoid String.contains and List.contains in Loops for Validation Logic
**Learning:** Using `String.contains()` on comma-separated values (like `"10,12"`) creates a correctness bug where "10" matches "1". Additionally, placing `String.split` and `List.contains` checks inside a loop evaluating an application list introduces O(N^2) complexity and massive GC overhead.
**Action:** Always parse delimited strings into a `HashSet` before the loop, and use `Set.add()` to simultaneously check for existence and add the item in O(1) time.
