## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-10 - O(N) Substring Match to O(1) Set Lookup

**Learning:** When checking if a delimited string (like `hours = "6,8,12"`) contains a value within a Java stream filter (`seckill.getHours().contains(...)`), it causes two problems: (1) O(N) substring search per element, which is inefficient in a loop, and (2) correctness issues where `.contains("2")` would erroneously match "12".

**Action:** Split the delimited string and convert it into a `Set` OUTSIDE the loop/stream to achieve O(1) exact-match lookups. Use `new LinkedHashSet<>(Arrays.asList(string.split(",")))` to safely check existence and guarantee insertion order if needed, while preventing substring matching bugs.
