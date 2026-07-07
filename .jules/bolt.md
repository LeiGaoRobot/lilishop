## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-07 - Optimize SeckillApply check performance by removing loop invariants and using Sets
**Learning:** Found an instance in Seckill promotion processing where array allocation/splitting (`String.split()`) and stream mapping/anyMatch were evaluated redundantly on every iteration over a collection. Additionally, existence checks were using O(n) `.contains()` followed by `.add()` on lists.
**Action:** Always hoist static or conditionally invariant data processing outside of loops. Convert collections used for lookup (like strings split into target value sets) into `Set`s for O(1) matching instead of iterating streams or arrays. For checking duplication before insertion, replace `List.contains(v)` with a single `Set.add(v)` call to collapse the existence check and insert into a single operation.
