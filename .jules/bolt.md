## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - O(N*M) Stream Filtering in Pagination
**Learning:** Found nested `stream().filter()` operations inside a pagination loop (`adminUserPage` in `AdminUserServiceImpl`) that matches `Role` and `Department` records against the current page of `AdminUser`s. This is an O(N*M) operation that runs for every user in the result page.
**Action:** Pre-compute lookup maps (e.g. `Map<String, Department>` and `Map<String, Role>`) from the fetched lists before iterating over the pagination results to achieve O(1) lookup time per user.
