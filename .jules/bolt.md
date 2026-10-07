## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-10-07 - Avoid Redundant String Splits and Stream Operations in Loops
**Learning:** Parsing strings (e.g., `hours.split(",")`) or performing O(N) `.anyMatch` operations on arrays within a loop introduces excessive allocation and CPU overhead.
**Action:** Parse delimited strings into a `Set` (e.g., `Set<String> set = new HashSet<>(Arrays.asList(str.split(",")))`) *outside* the loop and leverage O(1) `.contains()` lookups instead.
