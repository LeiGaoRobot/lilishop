## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-24 - Optimize O(N) List.contains to O(1) Set.add and hoist invariant loop operations
**Learning:** Found an `ArrayList` being used to store unique SKUs with an O(N) `contains()` check in a loop in `SeckillApplyServiceImpl.checkSeckillApplyList`. Also, a string split was happening inside the loop.
**Action:** Replaced `List<String> existSku` with a `Set<String>` and used `.add()` to check existence and insert in one O(1) operation. Hoisted the `hours.split(",")` and stream operations out of the loop into a single `HashSet` creation to avoid redundant calculations on each iteration.
