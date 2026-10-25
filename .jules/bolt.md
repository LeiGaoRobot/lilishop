## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-10-25 - Avoid String.contains and Loop Invariants
**Learning:** Using `String.contains()` on comma-separated strings inside streams can lead to correctness bugs due to partial substring matches. Repeatedly splitting arrays inside loops causes unnecessary overhead.
**Action:** Parse delimited strings into a `Set` for O(1) lookups and correctness. Always hoist invariant operations (like `split()`) outside of loops or streams to prevent repeated executions.
