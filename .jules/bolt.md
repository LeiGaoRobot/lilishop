## 2024-04-14 - String.contains() Bug vs. Set Lookups in Loops
**Learning:** Using `String.contains()` on a comma-delimited string (e.g., `"12,14".contains("1")`) causes unintended substring matches. Furthermore, splitting strings or executing `.contains()` on `ArrayList`s inside loops leads to O(N) or O(N^2) overhead.
**Action:** Always convert delimited strings or reference collections to a `Set` outside of loops to ensure correct O(1) matching and to eliminate redundant allocation/GC pressure. Leverage `Set.add()` for simultaneous existence check and insertion.
