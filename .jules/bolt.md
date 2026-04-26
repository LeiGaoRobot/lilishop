## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g. `"6,10,14".contains("1")`) not only performs poorly in loops but also introduces bugs due to substring matching ("1" matches "10").
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.stream(str.split(",")).collect(Collectors.toSet())`) before filtering to ensure correctness and O(1) performance.

## 2024-05-24 - Efficient distinct mapping & ComputeIfAbsent
**Learning:** In Spring Boot projects with many explicit list operations, iterating over collections to manually filter duplicates with `.contains()` in `if` conditions takes O(n^2) time complexity. Using `.stream().map().distinct().collect()` drops it to O(n) or O(n log n). Furthermore, manually fetching and instantiating maps for non-existent keys `if (!map.containsKey(key))` is better replaced by `computeIfAbsent()` which avoids duplicate hashes lookup.
**Action:** Replace `for` loop logic utilizing `.contains()` inside with stream equivalents and simplify manual list/map initialization loops with `computeIfAbsent` to improve speed and code conciseness.
