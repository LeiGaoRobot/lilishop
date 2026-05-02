## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-05-02 - Optimize string splitting and list containment in loops
**Learning:** In Java, using `.split(",")` and `ArrayList.contains()` inside a `for` loop, especially combined with Stream `anyMatch`, causes severe O(N^2) time complexity and massive object allocation (GC pressure) on every iteration.
**Action:** Always hoist invariant string splits outside the loop. Convert the resulting array to a `HashSet` to achieve O(1) existence checks. Use `!Set.add()` for checking duplicate item insertions securely in one O(1) step.
