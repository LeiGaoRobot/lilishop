## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-03-31 - [Hoist Invariant Allocations in Loops]
**Learning:** Found redundant date parsing and object creations (e.g., `new SimpleDateFormat()`, `Calendar.getInstance()`) inside nested loops for batch scheduling.
**Action:** Hoist invariant objects and date resolution outside loops to avoid excessive object allocation overhead and GC pressure.
