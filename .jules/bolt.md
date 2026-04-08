## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-04-08 - [O(N^2) Anti-Pattern and Invariant Hoisting in Loop]
**Learning:** Found O(N^2) complexity and unnecessary allocations inside loops where `String.split()` and `.contains()` on a List were performed repetitively inside a loop in `checkSeckillApplyList`.
**Action:** Always hoist invariant operations (like `String.split(",")`) outside of loops, and use `Set<String>` rather than `List<String>` or array streams for O(1) containment checks. Use `!set.add(item)` for simultaneously checking and adding to avoid duplicate `.contains()` + `.add()` checks.
