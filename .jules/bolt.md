## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2026-03-02 - Fast duplicate filtering using `Stream.distinct()`
**Learning:** Checking for duplicates by repeatedly calling `ArrayList.contains` inside a loop is $O(n^2)$. This is an anti-pattern.
**Action:** Replace `ArrayList.contains` filtering loops with Java Streams `map().distinct().collect(Collectors.toList())` to achieve $O(n)$ time complexity using internal HashSets, while also improving code readability.
