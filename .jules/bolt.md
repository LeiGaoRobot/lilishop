## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-04-12 - Token Generation O(N^2) Anti-Pattern
**Learning:** Found an O(N^2) anti-pattern during token generation where permissions are checked using `List.contains()` before adding, and `List.removeAll()` is invoked inside a loop on every iteration.
**Action:** Always use `LinkedHashSet` (or `HashSet`) to achieve O(1) insertions, and hoist invariant operations like `removeAll` outside the loop to avoid multiplying time complexity by the loop count.
