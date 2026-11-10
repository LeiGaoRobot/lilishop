## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2023-10-24 - O(N^2) Bottlenecks in Java Collection Containment Checks
**Learning:** Found multiple instances where `List.contains()` was used inside loops to ensure uniqueness before adding items to a list (e.g., in `EsGoodsSearchServiceImpl.java`). This creates an O(N^2) bottleneck, especially problematic for search/aggregation paths.
**Action:** When enforcing uniqueness in a collection inside a loop, use a `Set` (such as `LinkedHashSet` if order matters) rather than a `List` to achieve O(1) lookup times.
