## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2024-05-24 - O(1) Set lookup vs O(N) List contains
**Learning:** Using List.contains() inside a loop causes an O(N²) anti-pattern which degrades performance linearly.
**Action:** Use a Set (e.g. HashSet) for fast O(1) membership lookups during loop iterations.
