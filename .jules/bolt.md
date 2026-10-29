## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2023-10-24 - Avoid O(N^2) String.contains on Delimited Strings
**Learning:** Using `String.contains` on a comma-separated string (e.g., `"a,b,c".contains(x)`) inside a loop is an O(N^2) anti-pattern. More importantly, it can cause subtle correctness bugs due to partial substring matches (e.g., matching 'id' in 'goodsId').
**Action:** Parse the delimited string into a `java.util.Set` beforehand using `Arrays.asList` (or Guava) to ensure correctness and achieve O(1) lookup time. Prefer `LinkedHashSet` if insertion order needs to be maintained.

## 2023-10-24 - Avoid O(N^2) List.contains in Loops
**Learning:** Using `List.contains` inside nested loops or stream aggregations introduces O(N^2) complexity, leading to performance bottlenecks during high-volume operations (e.g., ElasticSearch aggregations).
**Action:** Hoist the list into a `Set` (e.g., `HashSet`) before the loop. This converts the inner `contains()` check to O(1) lookup time, significantly speeding up nested data processing.
