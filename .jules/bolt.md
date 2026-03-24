## 2026-03-24 - Array list nested loop removal
**Learning:** Found an O(N*M) nested loop inside `delete(String[] skuIds)` doing `.equals` checks for cart items. This is a common performance anti-pattern.
**Action:** Replace nested loops filtering a List with `Set<String>` and `.removeIf(item -> set.contains(item))` to reduce time complexity to O(N).
