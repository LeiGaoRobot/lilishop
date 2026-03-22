## 2024-05-24 - O(N*M) Stream Filtering in Pagination
**Learning:** Found nested `stream().filter()` operations inside a pagination loop (`adminUserPage` in `AdminUserServiceImpl`) that matches `Role` and `Department` records against the current page of `AdminUser`s. This is an O(N*M) operation that runs for every user in the result page.
**Action:** Pre-compute lookup maps (e.g. `Map<String, Department>` and `Map<String, Role>`) from the fetched lists before iterating over the pagination results to achieve O(1) lookup time per user.
