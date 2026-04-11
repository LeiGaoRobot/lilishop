## 2024-05-18 - String.contains() causes unintended substring matching bugs and O(N) lookup
**Learning:** Checking existence in a delimited string using `String.contains()` inside stream filters or loops (like `memberCoupon.getScopeId().contains(category)`) can match substrings unintentionally (e.g., matching "12" in "123"). It also causes O(N) performance issues.
**Action:** Convert delimited strings to `Set<String>` (e.g., `Arrays.asList(scopeId.split(",")).stream().collect(Collectors.toSet())`) before the loop/stream and use `Set.contains()` for O(1) exact matching.
