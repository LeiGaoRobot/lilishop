## 2026-03-02 - Fast duplicate filtering using `Stream.distinct()`
**Learning:** Checking for duplicates by repeatedly calling `ArrayList.contains` inside a loop is $O(n^2)$. This is an anti-pattern.
**Action:** Replace `ArrayList.contains` filtering loops with Java Streams `map().distinct().collect(Collectors.toList())` to achieve $O(n)$ time complexity using internal HashSets, while also improving code readability.
