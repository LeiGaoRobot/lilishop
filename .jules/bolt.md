## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-18 - [Batch distributions of Coupon]
**Learning:** Found an N+1 queries issue during batch promotion/coupon distributions. The `sendCoupon` process iterated per member and fetched the Coupon entity inside, resulting in huge N+1 problems.
**Action:** When distributing resources across many members, process it resource-first (fetch the resource once, generate all assignments for members, and save all assignments in one batch using saveBatch).
