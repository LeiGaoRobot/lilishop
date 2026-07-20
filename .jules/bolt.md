## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-20 - Optimizing List.removeAll() overhead
**Learning:** Using `removeAll()` on an `ArrayList` against another `ArrayList` has O(N * M) time complexity because `ArrayList.contains()` takes O(M) time. Moving this outside of loop bodies and changing collections to `Set` reduces the lookup time to O(1).
**Action:** When performing `removeAll()` or frequent `.contains()` checks, change the reference collection type from `List` to `Set` (like `LinkedHashSet` if insertion order matters).
