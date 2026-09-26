## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-24 - Hoist loop invariants and replace list.contains with set.add
**Learning:** Found two O(N) operations in `checkSeckillApplyList` method of `SeckillApplyServiceImpl`.
1. `hours.split(",")` was being run inside a loop over `seckillApplyList`, causing redundant allocations and splits.
2. `List.contains(skuId)` was used inside the same loop to check for duplicate skus, causing an O(N) lookup.
**Action:**
- Extract `hours.split(",")` and create a `Set<String>` before the loop for O(1) lookup.
- Change `List<String> existSku = new ArrayList<>();` to `Set<String> existSku = new HashSet<>();` to use O(1) existence checks.
- Alternatively, we can use `if(!existSku.add(seckillApply.getSkuId()))` which does the check and add in one O(1) operation.
