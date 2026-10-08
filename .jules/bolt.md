## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-10-08 - Optimize O(N) List.contains to O(1) Set lookup in frequently iterated Cart render logic
**Learning:** Checking `String.contains()` repeatedly on a delimited string (like `"A,B,C".contains("A")`) inside a loop over cart SKUs introduces both an O(N) allocation and lookup overhead, as well as a subtle correctness bug due to partial matches (e.g., `"10,12,14".contains("1")` returns `true`).
**Action:** When filtering Cart SKUs by checking if they are contained in a delimited `scopeId` string (e.g., in `CouponRender` and `FullDiscountRender`), explicitly parse the string into a `java.util.LinkedHashSet` BEFORE iterating over the cart or using Java Streams. Use `scopeSet.contains()` inside the lambda or loop for an O(1) exact-match lookup that prevents partial string matching bugs and improves performance.
