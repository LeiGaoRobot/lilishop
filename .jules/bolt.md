## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-19 - Optimize List.contains to Set and Hoist Operations out of Loops
**Learning:** Found a recurring anti-pattern where delimited strings (e.g., `hours.split(",")`) were re-parsed on every iteration inside a loop, and `List.contains()` was used for lookups inside the loop (resulting in O(N) lookup time on every iteration). This caused unnecessary allocation and CPU overhead.
**Action:** When working with collections and loops in this codebase, explicitly check if the reference collection or string can be hoisted outside the loop and converted to a `HashSet`. This avoids O(N) allocation per iteration and converts the O(N) `contains()` check to an O(1) `Set.contains()` check. Additionally, `Set.add()` can be used to perform existence check and insertion in a single O(1) operation safely.
