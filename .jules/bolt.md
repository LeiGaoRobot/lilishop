## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-05-24 - [String Splitting & List Checks in Loops]
**Learning:** Parsing fixed delimited strings (`hours.split(",")`) into arrays and scanning them with Streams or using `List.contains` inside nested loops creates excessive O(N) object allocation overhead and quadratic lookup time complexity. Furthermore, adding items to a `List` after a `contains()` check is an anti-pattern.
**Action:** When repeatedly checking values against a delimited string or accumulating unique items, hoist the string parsing operation *outside* the loop, populate a `Set` for O(1) membership lookups, and leverage `Set.add(item)` which returns a boolean to safely perform both the existence check and insertion in a single operation.
