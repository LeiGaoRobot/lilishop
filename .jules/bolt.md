## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-11-20 - Optimize List.contains to Set.add in loops
**Learning:** Using `List.contains` inside a loop creates an O(N^2) bottleneck. When building a unique List from a stream or loop, use `Set.add()` which returns a boolean. This safely combines existence checking and insertion in a single O(1) operation.
**Action:** When filtering unique items in a loop while retaining them in a `List`, utilize `LinkedHashSet.add()` for O(1) checks before adding to the `List`.
