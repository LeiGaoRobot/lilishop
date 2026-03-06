## 2024-05-18 - [Batch distributions of Coupon]
**Learning:** Found an N+1 queries issue during batch promotion/coupon distributions. The `sendCoupon` process iterated per member and fetched the Coupon entity inside, resulting in huge N+1 problems.
**Action:** When distributing resources across many members, process it resource-first (fetch the resource once, generate all assignments for members, and save all assignments in one batch using saveBatch).
