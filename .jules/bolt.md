## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-04-16 - Hoist loop invariants and avoid O(N^2) list lookups
**Learning:** Checking existence in a `List` within a loop creates an O(N^2) performance bottleneck. Additionally, splitting strings or creating streams inside a loop creates excessive GC pressure and CPU overhead on every iteration.
**Action:** Use `Set` instead of `List` for O(1) lookups, combine existence check and insertion using `Set.add()`, and hoist invariant operations like string splits and `Set` conversions outside of loops.
