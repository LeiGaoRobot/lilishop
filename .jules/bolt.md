## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-10-27 - O(N²) List Contains to O(1) Set Optimization
**Learning:** Found a classic O(N²) anti-pattern where a list is repeatedly checked for `contains()` inside a loop for existence checking (`existSku.contains(skuId)`). In `SeckillApplyServiceImpl.checkSeckillApplyList`, this was exacerbated by an `Arrays.stream().anyMatch()` on a `.split(",")` occurring redundantly *inside* the loop.
**Action:** When validating items within a loop, hoist redundant string manipulations (like split) and array creations outside the loop into a `java.util.Set` for O(1) lookups. Additionally, replace explicit `contains()` followed by `add()` on a collection with `Set.add()` which performs both operations efficiently and returns a boolean indicating whether the item was new.
