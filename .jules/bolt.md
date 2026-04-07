## 2024-04-07 - Avoid O(N) contains inside loop
**Learning:** Found O(N) `List.contains()` operation inside a loop in `CartServiceImpl.java`. This can degrade performance when the number of items is large.
**Action:** Replace `List<String> storeIds = new ArrayList<>();` with `Set<String> storeIds = new HashSet<>();` to optimize the lookup to O(1).
