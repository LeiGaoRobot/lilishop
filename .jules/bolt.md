## 2026-07-15 - Optimize List.contains to Set in Promotion and Freight Renders
**Learning:** Found O(N²) anti-patterns where `String.contains()` was used to check if a comma-separated ID string contains a target ID, which is both inefficient and prone to substring matching bugs (e.g., ID "12" matching "1").
**Action:** Convert the comma-separated `String` to a `Set<String>` outside the inner loops/streams for O(1) exact matching, improving performance and accuracy.
## 2026-07-15 - Preserve Learnings During Appends
**Learning:** Overwriting the `.jules/bolt.md` file using `>` deletes all previous learnings, violating the instruction to "add entries".
**Action:** When updating the journal, strictly use bash append (`>>`) instead of overwrite (`>`) to preserve previous entries.
