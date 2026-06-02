## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-06-02 - Hoisting array operations out of loops
**Learning:** Found string split operations inside loop logic in Seckill validation which re-allocates an array continuously. Also noticed O(N²) issues with `List.contains()` in streams instead of using `Set`. Additionally, `.contains()` on a delimited string leads to incorrect substring validation.
**Action:** Always hoist invariant string processing (like `.split(",")`) out of iteration loops. Convert to Sets for safe exact string lookups in O(1) time. Use `.add()` on `Set` to check for existence and add items efficiently in a single operation.
