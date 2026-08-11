## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-08-11 - [O(N^2) Anti-Pattern in Collection Membership Checking]
**Learning:** Checking for membership using `List.contains()` in loops (like checking `existSku.contains()`) or using `String.contains()` on comma-separated strings inside streams is O(N^2). Also, invariant operations like `hours.split(",")` inside loops cause unnecessary object creation and processing.
**Action:** Always convert lists or delimited strings to a `Set` (e.g., `HashSet`) BEFORE the loop to achieve O(1) lookup time. Additionally, use `Set.add(item)` to perform both the existence check and insertion safely in a single O(1) operation.
