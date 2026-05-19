## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-05-09 - [O(N^2) Anti-Pattern in CouponRender]
**Learning:** Found O(N^2) complexity in `CouponRender.java` where `String.contains()` was used to check if an ID exists in a comma-separated string `scopeId` within a stream filter. This also introduces bug if scopeId contains "12" and the tested id is "1", as "12".contains("1") returns true.
**Action:** Always convert comma-separated strings to a `Set` (e.g., `HashSet`) outside the stream/loop, then use `.contains()` for O(1) exact matching, improving performance and fixing partial-match bugs.
