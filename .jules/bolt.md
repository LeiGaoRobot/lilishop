## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-10-20 - O(N^2) Performance Bottleneck with List.contains in SeckillApplyServiceImpl
**Learning:** Found a performance bottleneck where `List.contains()` was used inside a loop to check for existing SKUs before adding them to a list, resulting in an O(N^2) operation.
**Action:** Replaced `List<String> existSku = new ArrayList<>()` with `Set<String> existSku = new HashSet<>()` and refactored the existence check to use `Set.add()`. The `.add()` method returns false if the element is already present, combining the O(1) existence check and insertion into a single operation. This resolves the bottleneck while retaining correctness.
