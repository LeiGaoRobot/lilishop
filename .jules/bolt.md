## 2026-06-10 - Set instead of string split/contains array/List in loops
**Learning:** Using `String.contains()` when the string actually represents an array (e.g., delimited by comma like `hours`) can lead to substring match bugs (e.g., `"12,13"`.contains("1") is true). Also doing `hours.split(",")` inside a loop is inefficient O(N) overhead on every iteration. `List.contains()` is also O(N).
**Action:** Convert delimited strings to a `Set` outside the loop, use `Set.contains()` inside the loop for O(1) matching and correctness.
