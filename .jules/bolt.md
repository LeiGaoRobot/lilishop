## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2025-01-20 - Hoisting O(N) allocations in validation loops and utilizing Set for constraints
**Learning:** Found an anti-pattern in `SeckillApplyServiceImpl` where `hours.split(",")` string splitting and `Arrays.stream().anyMatch()` were repeatedly called inside a loop over validation payload. It also used an `ArrayList` `.contains()` for existence check which made it an O(N²) lookup. Redundant allocation inside loops leads to high GC overhead.
**Action:** When validating payloads over a loop, hoist fixed allocations (like splitting comma-separated constraint strings) out of the loop and prefer using a `Set` (e.g. `HashSet`) for `contains()` checks or constraint uniqueness validations instead of `List.contains()` and `List.add()`.
