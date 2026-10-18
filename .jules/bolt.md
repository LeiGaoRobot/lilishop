## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-10-16 - [String.split and List.contains in Loops]
**Learning:** Found O(N^2) complexity and redundant O(N) allocation in loops where delimited strings were being dynamically checked (e.g., `memberCoupon.getScopeId().contains(category)`) or array-toList operations occurred inside stream filters (e.g., `Arrays.asList(ignoreOriginKeys).contains()`). `String.contains` on comma-separated IDs also introduces correctness bugs with partial string matches (e.g., "123,456" contains "12").
**Action:** Always hoist `String.split()` and convert the array to a `Set` (e.g., `LinkedHashSet`) outside the loop or stream. This avoids redundant allocation and ensures O(1) lookup time, while preventing substring matching bugs.
