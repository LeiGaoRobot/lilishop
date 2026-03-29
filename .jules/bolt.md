## 2024-05-24 - [Avoid List.contains in Loops]
**Learning:** Checking for element existence using `List.contains()` inside loops leads to O(n^2) time complexity.
**Action:** Replace `List` with `Set` (e.g. `HashSet`) for O(1) lookups inside loops when checking for element existence, especially in batch processing logic.
