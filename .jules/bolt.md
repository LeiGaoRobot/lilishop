## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-18 - Hoist Invariants and Opt O(N^2) Contains
**Learning:** Avoid redundant `split(",")` and `Arrays.stream().anyMatch()` inside loops, which cause heavy object allocation overhead. Combining this with O(N) `List.contains` yields a severe O(N^2) anti-pattern.
**Action:** Hoist the string split and Set conversion outside the loop, use a `HashSet` for O(1) existence checks inside the loop, and use `Set.add()` which inherently returns `false` if already present to combine check and add into one operation.
