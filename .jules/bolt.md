<<<<<<< Updated upstream
## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g. `"6,10,14".contains("1")`) not only performs poorly in loops but also introduces bugs due to substring matching ("1" matches "10").
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.stream(str.split(",")).collect(Collectors.toSet())`) before filtering to ensure correctness and O(1) performance.
=======
## 2026-03-28 - Avoid O(N²) List.contains() in Java Streams
**Learning:** Found an O(N²) anti-pattern in `seller-api/src/main/java/cn/lili/controller/goods/GoodsStoreController.java` where `List.contains()` was used inside a Java stream filter. This is especially bad for batch processing logic.
**Action:** Always convert the reference collection to a `Set` (e.g., using `Collectors.toSet()`) beforehand to achieve O(1) lookup time when filtering streams.
>>>>>>> Stashed changes
