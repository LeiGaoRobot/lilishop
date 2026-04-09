## 2026-04-09 - [Optimize existence checks and redundant operations]
**Learning:** Invariant operations inside loops like redundant string splitting and stream creation, as well as `List.contains` cause O(N^2) complexity and GC pressure.
**Action:** Use a `Set` for `existSku`, hoist `hours.split` outside the loop, and use `Set.add` for check-and-insert behavior.
