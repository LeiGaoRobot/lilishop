## 2024-04-20 - String.contains() causes unintended substring matching bugs and O(N) performance on delimited strings

**Learning:** When using `String.contains()` on comma-delimited strings (e.g., `hours.contains("6")` where hours is "16,18,20"), it matches substring (e.g., "16" contains "6"), causing correctness bugs. Furthermore, running this operation inside a stream filter creates high O(N) allocation overhead per element.
**Action:** Always parse the comma-delimited string into a `Set<String>` outside the loop, then use `Set.contains()` inside the loop. This ensures exact matching and achieves O(1) lookup time, eliminating the bug and the performance penalty.
