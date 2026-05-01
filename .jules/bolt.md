## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-01 - Avoid List.contains in loops and hoist invariant String.split

**Learning:** Using `List.contains` inside a loop creates an O(N^2) complexity anti-pattern, common in this codebase for deduplicating IDs or checking existence. In addition, invariant operations like `String.split` inside loops can create excessive GC pressure and CPU overhead on every iteration.

**Action:** Replace `List` with `Set` (e.g. `HashSet`) when deduplicating, leveraging `Set.add` which returns boolean to simultaneously check and insert in O(1) time. Hoist invariant string parsing operations like `split()` outside of loops.
