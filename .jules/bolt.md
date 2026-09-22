## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-22 - Optimize O(N²) List/String loops
**Learning:** Hoisting invariant operations like string splitting outside loops and replacing `ArrayList` with `Set` is critical to avoiding O(N²) lookup times and repeated GC allocations in loops within this codebase.
**Action:** In loops, always verify if `contains()` checks can be refactored into `Set` O(1) lookups and evaluate if expensive setup calculations can be hoisted out.
