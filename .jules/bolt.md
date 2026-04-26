## 2023-10-27 - [O(N^2) Anti-Pattern in Batch Processing]
**Learning:** Found O(N^2) complexity in batch processing logic where `List.contains()` is used inside a stream filter over a large collection.
**Action:** Always convert collections to `Set` (e.g., `HashSet`) before using `.contains()` in loops or stream filters to achieve O(1) lookup time, especially for bulk operations.

## 2024-05-24 - [Avoid String.contains() on delimited strings]
**Learning:** Using `String.contains()` on comma-delimited strings (e.g. `"6,10,14".contains("1")`) not only performs poorly in loops but also introduces bugs due to substring matching ("1" matches "10").
**Action:** Always parse delimited strings into a `Set` (e.g., `Arrays.stream(str.split(",")).collect(Collectors.toSet())`) before filtering to ensure correctness and O(1) performance.
## 2026-03-27 - Optimize List.contains inside Java Stream to O(1)
**Learning:** This application has an anti-pattern of doing `stream().filter(i -> list.contains(i.getSkuId()))`. Since `list.contains()` is O(n), this makes the entire check O(N^2), which is especially bad in batch operations like updating stocks. Replacing the reference `List` with a `Set` ensures O(1) lookups and significantly improves batch processing. Also, compiling with JDK 21 requires updating `lombok.version` in `pom.xml` if encountering `com.sun.tools.javac.tree.JCTree$JCImport` errors or just supplying `-Dlombok.version=1.18.32` through mvn.
**Action:** When inspecting loops or streams, watch for `contains()` calls on lists. When found, convert the `List` to a `HashSet` before the stream or loop, preventing an O(N^2) bottleneck. When verifying Java compilation, use `-Dlombok.version=1.18.32` if encountering `javac.tree` compilation errors.
