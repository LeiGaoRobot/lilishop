## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-10-10 - String.contains on Delimited Strings Inside Stream Filters
**Learning:** Using `String.contains()` inside a stream filter for delimited strings (e.g. `categoryList.stream().filter(o -> goodsSku.getCategoryPath().contains(o.get("id").toString()))`) not only introduces O(N²) overhead but also causes partial match correctness bugs (e.g. "11,12" matching "1").
**Action:** Parse delimited strings into a `LinkedHashSet` beforehand. This guarantees O(1) lookup inside the stream and prevents partial substring matches, while preserving order.
