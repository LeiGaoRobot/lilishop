## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-01 - [O(N) Lookups in `CouponRender.java` and `SeckillApplyServiceImpl.java`]
**Learning:** Found O(N) complexity string split `contains()` and stream lookups in `SeckillApplyServiceImpl` and `CouponRender`. The string `contains()` on delimited lists and list `contains` over O(N) items inside loops or maps creates bottlenecks on large shopping carts or flash sale items.
**Action:** Always parse comma-delimited list to `Set` or use `Set` conversion for array elements before stream processing or iteration in loops to enforce O(1) performance.
