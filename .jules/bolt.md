## 2026-03-28 - Avoid O(N²) List.contains() in Java Streams
**Learning:** Found an O(N²) anti-pattern in `seller-api/src/main/java/cn/lili/controller/goods/GoodsStoreController.java` where `List.contains()` was used inside a Java stream filter. This is especially bad for batch processing logic.
**Action:** Always convert the reference collection to a `Set` (e.g., using `Collectors.toSet()`) beforehand to achieve O(1) lookup time when filtering streams.
