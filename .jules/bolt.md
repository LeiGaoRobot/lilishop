## 2024-05-14 - Clean up temporary benchmarking files
**Learning:** Leftover test and benchmarking files (`Test*.java`, `*.class`, `*.log`) pollute the git patch and lead to PR rejections.
**Action:** Always clean up generated files and classes explicitly (`rm`) before calling `request_code_review` or completing the task.
