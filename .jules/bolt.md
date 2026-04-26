## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g. `"6,10,14".contains("1")`) not only performs poorly in loops but also introduces bugs due to substring matching ("1" matches "10").
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.stream(str.split(",")).collect(Collectors.toSet())`) before filtering to ensure correctness and O(1) performance.

## 2024-04-19 - Avoid Reinstantiating Collections in Loop for Contains Check
**Learning:** Checking for elements in an array or un-indexed collection within a loop using `Arrays.asList(arr)` leads to repetitive O(N) allocation overhead per iteration and per method call.
**Action:** Extract arrays that serve as lookup references to `private static final Set<String>` constants at the class level to prevent unnecessary allocations and to achieve O(1) lookups instead of O(N).
