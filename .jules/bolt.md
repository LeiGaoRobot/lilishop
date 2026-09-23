## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2023-10-27 - [Optimize List.contains/String.contains to Set in loops]
**Learning:** Found multiple instances where `.contains()` operations on strings or lists inside loops and stream operations were causing overhead, specifically `String.contains()` in `SeckillApplyServiceImpl` and `String.contains()` parsing delimited string `IGNORE_FIELD` in `EsIndexUtil` and `EsGoodsIndexServiceImpl`.
**Action:** When performing existence checks against a delimited string in a loop, pre-parse the delimited string into a `java.util.Set` outside the loop, giving O(1) lookup time instead of repeatedly calling `String.contains()` inside the loop which checks substrings and can cause subtle bugs and O(N) complexity.
