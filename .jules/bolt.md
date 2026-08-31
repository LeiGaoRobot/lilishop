## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-08-31 - Optimize String.contains() and List.contains() in Loops
**Learning:** Found an O(N^2) anti-pattern where a comma-separated string (e.g. `seckill.getHours().contains(...)`) or an array/list is iterated over and searched repeatedly. Using `.contains()` on a comma-separated string without proper delimiter checking can cause logic bugs (e.g., "12" containing "1"), and converting it to a Set outside the loop makes lookups O(1).
**Action:** Replace `list.contains()` or `string.contains()` within `.stream().filter()` or loop with a `Set` created outside the loop. Avoid creating `Set` *inside* the filter/loop as that would cause excessive allocation and defeat the purpose.
