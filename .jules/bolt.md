## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-07-28 - Optimize List.contains to Set and hoist string split
**Learning:** Checking elements dynamically split inside a loop results in multiple array allocations and stream initializations overhead per loop. Also, List.contains() has O(N) complexity which can scale O(N^2) for loop intersections.
**Action:** Always hoist invariant string split out of a loop. Whenever dealing with collections and loop conditionals dynamically looking up containment, convert List or arrays into Set first and leverage Set.add for existence check in O(1) performance.
