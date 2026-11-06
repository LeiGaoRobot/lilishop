## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-11-06 - O(N²) Anti-pattern with List/Array checks inside loops
**Learning:** Using `String.split` and `Arrays.stream().anyMatch()` or `List.contains()` inside loops for membership testing creates severe O(N²) bottlenecks in business logic.
**Action:** Lift static array/string operations out of loops and parse data into a `Set` (e.g., `LinkedHashSet` if insertion order matters, or `HashSet`) before the loop. Use `Set.add()` which returns a boolean to efficiently combine existence checks and insertions in a single O(1) operation.
