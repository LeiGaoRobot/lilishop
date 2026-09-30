## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.
## 2026-09-29 - Optimize List.contains to Set for O(1) lookups
**Learning:** Checking existence in loops using `List.contains()` causes O(N^2) complexity. Similarly, string splitting inside loops causes repetitive object allocation and processing overhead. Additionally, using `String.contains()` on delimited strings can cause subtle correctness bugs due to partial matches (e.g., `"10,12,14".contains("1")`).
**Action:** When performing membership checks, especially inside loops or streams, parse delimited strings into a `Set` beforehand. This ensures exact matching, resolves correctness issues with partial substrings, and provides O(1) lookup time, optimizing overall complexity. Hoist invariant operations like string splitting outside loops.
