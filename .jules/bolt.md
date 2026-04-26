## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g. `"6,10,14".contains("1")`) not only performs poorly in loops but also introduces bugs due to substring matching ("1" matches "10").
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.stream(str.split(",")).collect(Collectors.toSet())`) before filtering to ensure correctness and O(1) performance.

## 2025-02-23 - Avoid ArrayList resizing overhead by pre-allocating capacity
**Learning:** Initializing an `ArrayList` with default capacity and adding elements in a loop can cause multiple array allocations and array copies, particularly for potentially large data sets like files or list of entities retrieved from DB queries. Using `Stream.map(..).collect(Collectors.toList())` or simply pre-allocating the `ArrayList` with the known size of the source collection completely avoids this resizing overhead and is noticeably faster and memory efficient.
**Action:** When transforming a known-size list or collection (e.g. mapping `File` to `String` keys), always pre-allocate the new `ArrayList` with the source collection's `.size()`, or use idiomatic Java Streams which often handle sizing efficiently.
