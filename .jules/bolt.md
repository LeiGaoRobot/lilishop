## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-06-09 - Set replaces List.contains for O(1) performance lookup inside loops
**Learning:** Found O(N²) complexity in array iteration checking `List.contains()` multiple times over arrays created via `.split(",")`. Also found `List.contains` for existence checking using dynamically added strings which incurs a penalty inside loops.
**Action:** Always hoist invariant string split operations out of loops to create standard collections (`List` or `Set` depending on index lookup). More importantly, leverage `Set` conversion for lookup tables (e.g. `!existSku.add(sku)`) to achieve combined existence checking and insertion in a single O(1) step.
