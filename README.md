# 100 Days of Code — 2026
**UPES ACM and ACM-W Student Chapters**

---

## What is this challenge?

The 100 Days of Code Challenge is a structured, daily coding programme running from **15th June to 22nd September 2026**. Every participant commits to solving two coding problems each day — one on LeetCode, one on the ACM platform — and submitting solutions to this GitHub repository.

The goal is straightforward: build consistency, sharpen problem-solving, and develop the discipline of writing clean code every single day.

---

## Important Dates

| Event | Date | Time |
|---|---|---|
| GitHub Workshop | 13th June 2026 | 8:00 PM |
| Challenge Begins | 15th June 2026 | — |
| Challenge Ends | 22nd September 2026 | — |
| Weekly Debugging Sessions | Every Sunday | 9:00 PM – 10:00 PM |
| Milestone Contest — Day 21 | 5th July 2026 | — |
| Milestone Contest — Day 51 | 4th August 2026 | — |
| Milestone Contest — Day 99 | 21st September 2026 | — |
| Milestone Contest — Day 100 | 22nd September 2026 | — |

---

## How the Challenge Works

### Daily Questions
Two questions are released every day at **12:00 AM** on the ACM Platform.

- **Question 1** — A LeetCode problem. Must be solved on your registered LeetCode account and also pushed to this GitHub repository.
- **Question 2** — A DSA/Technical problem. Must be submitted here on GitHub.

Both must be submitted within **24 hours** of release. Previous day solutions and weekly handouts are shared to support learning.

### Weekly Debugging Challenges
Every Sunday from 9:00 PM to 10:00 PM, a themed debugging challenge is conducted. You will be given broken code and asked to identify and fix the errors. The corrected solution must be pushed to GitHub before the announced deadline.

**Important:** For Weekly Debugging Challenges, only **C** and **Python** are accepted. C++ and Java will not be evaluated for these sessions.

### Milestone HackerRank Contests
On Day 21, 51, 99, and 100, a contest is held on HackerRank consisting of three questions based on concepts from the preceding week. Daily questions still release on these days as usual. Milestone contests contribute to the overall leaderboard and serve as a checkpoint of your progress.

You **must** participate using a HackerRank account registered with your **official UPES email address**. Submissions from personal email accounts will not be counted.

---

## Permitted Languages

| Context | Allowed Languages |
|---|---|
| Daily Coding Challenges | C, C++, Java, Python |
| Weekly Debugging Challenges | C, Python only |
| Milestone HackerRank Contests | As permitted by HackerRank |

You may switch languages freely across daily challenges. No language outside of C, C++, Java, and Python is permitted for daily submissions — files in any other language (`.js`, `.go`, `.rs`, etc.) will not be evaluated. For debugging sessions, only C and Python are accepted — no exceptions.

---

## Repository Structure

Every participant works inside a single personal folder. The folder lives inside a `DSA` directory at the root of the repository. The structure is as follows:

```
100DaysOfCode-2026/
└── DSA/
    └── YourName_YourSAPID/
        ├── Day_1/
        │   ├── Question1_LeetCode.cpp
        │   └── Question2.cpp
        ├── Day_2/
        │   ├── Question1_LeetCode.py
        │   └── Question2.py
        └── ...
```

### Sunday Debug Repository Structure

For **Weekly Debugging Challenges**, participants must **not** submit their files inside the `DSA` folder. Instead, they must use the following structure:

```text
100DaysOfCode-2026/
└── Sunday_Debug/
    └── Sunday_Debug_WeekNumber/
        └── Participant_Name_SAPID/
            └── Question
```

**Example:**

```text
100DaysOfCode-2026/
└── Sunday_Debug/
    └── Sunday_Debug_Week1/
        └── John_500123456/
            └── Question.c
```

### Step-by-step setup

**Step 1 — Fork the repository**

Fork the official repository at: `https://github.com/upesacm/100DaysOfCode-2026`

This creates your own copy of the repository under your GitHub account. All your work happens in this fork.

---

**Step 2 — Add your files**

Choose whichever method suits you.

**Method A: Using Git (command line)**

```bash
# Clone your fork to your local machine
git clone https://github.com/YOUR_USERNAME/100DaysOfCode-2026.git

# Navigate into it
cd 100DaysOfCode-2026

# Create your folder structure
mkdir -p "DSA/YourName_SAPID/Day_1"

# Add your solution files inside , then commit and push
git add .
git commit -m " Submission - YourName - SAPID"
git push origin main
```

**Method B: Using the GitHub website**

1. Open your fork on GitHub
2. Click **Add file → Create new file**
3. In the file path box, type: `DSA/YourName_SAPID/Day_1/Question1_LeetCode.cpp`
   — GitHub will automatically create the intermediate folders
4. Paste your solution and click **Commit changes**
5. Repeat for `Question2`

---

**Step 3 — Open a Pull Request**

After committing your files, you must open a Pull Request. Committing alone does not submit your work for review — a Pull Request is mandatory.

See the [Pull Request Guidelines](#pull-request-guidelines) section below for the exact steps and title format.

### Folder naming — what is and is not acceptable

Your personal folder must follow the `Name_SAPID` format precisely. Deviations cause problems with automated tracking.

| Format | Status |
|---|---|
| `John_5900123XX` | Correct |
| `John` | Incorrect — SAP ID missing |
| `5900123XX` | Incorrect — name missing |
| `JohnDoe` | Incorrect — SAP ID missing |

Day folder names must also follow the standard exactly.

| Format | Status |
|---|---|
| `Day_1`, `Day_2`, `Day_10` | Correct |
| `day1`, `DAY1`, ``, `Day1` | Incorrect |

---

## Submission Rules

### What to submit
- Source code files only (`.c`, `.cpp`, `.java`, `.py`, etc.)
- One solution per question per day — do not upload multiple versions of the same file
- Both questions for a day must be inside that day's folder before you push

### What not to submit
- PDF, DOCX, PNG, or any non-source-code format
- Binary files such as `.exe`, `.zip`, `.class`, `.o`, `.out`
- IDE configuration folders such as `.idea/`, `.vscode/`, `build/`, `node_modules/`
- Files belonging to other participants

### GitHub workflow

You must follow the **Fork → Pull Request** workflow. Direct pushes to the main repository are not permitted.

Pull Requests must be raised from the **`main` branch** of your fork. PRs opened from feature branches or any other branch will not be considered for evaluation.

Opening a Pull Request before the deadline and pushing additional commits to it afterward is acceptable — the submission will still be counted. Late pull requests (after the 24-hour window) will also be accepted, though points may be affected as per leaderboard policy.

Do not open multiple Pull Requests for the same day's submission. If you need to update a submission, push the changes to your existing PR.

---

## Pull Request Guidelines

### How to open a Pull Request

1. Go to your fork on GitHub
2. Click **Contribute → Open Pull Request**
3. Verify the settings:
   - **Base repository:** `upesacm/100DaysOfCode-2026`
   - **Base branch:** `main`
   - **Head repository:** your fork
   - **Compare branch:** `main`
4. Set the Pull Request title using the format below
5. Click **Create Pull Request**

### Pull Request title format

Every PR must follow this exact format:

```
Day X Submission - Name - SAPID
```

Examples:
- `Day 1 Submission - John - 500123456`
- `Day 10 Submission - Olivia - 500198765`

PRs with missing or incorrectly formatted titles may not be linked to your account during evaluation.

### Important: committing is not submitting

Pushing files to your fork only saves them to your copy of the repository. Your submission is **not received** until you open a Pull Request. If you commit your solutions but forget to raise a PR, your work will not be evaluated.

### Pre-PR checklist

Before opening a Pull Request, verify each of the following:

- [ ] Your folder is placed inside `DSA/`
- [ ] Your folder is named in the `Name_SAPID` format
- [ ] Day folders are named `Day_1`, `Day_2`, etc. (without a space)
- [ ] Both `Question1_LeetCode` and `Question2` are present in the day folder
- [ ] Solution files are source code — no ZIP, PDF, or binary files
- [ ] You have not modified any other participant's files
- [ ] No IDE or build folders (`.idea/`, `.vscode/`, `build/`) are included
- [ ] The PR is raised from the `main` branch of your fork
- [ ] The PR title follows the `Day X Submission - Name - SAPID` format

---

## Leaderboards

Four leaderboards are maintained throughout the challenge:

- **Weekly Leaderboard** — based on daily challenge performance
- **Weekly Debugging Challenge Leaderboard** — based on Sunday debugging sessions
- **Milestone Contest Leaderboard** — based on HackerRank milestone contest scores
- **Combined Overall Leaderboard** — aggregate of all the above

### Tie-Breaking

If two participants finish with identical scores, the following criteria are applied in order:

1. **Code Readability and Optimisation** — better-structured, more efficient code ranks higher
2. **Average Submission Time** — faster average submissions break ties that remain after step 1
3. **Consistency Streak** — a longer uninterrupted daily submission streak breaks ties that remain after step 2

---

## Code of Conduct

- Plagiarism, code sharing, and unauthorised collaboration are strictly prohibited
- You must not modify, rename, or delete any folder other than your own
- Submissions made by copying another participant's solution will be disqualified
- All participants are expected to conduct themselves professionally throughout the event
- The organising committee's decisions on scoring, rankings, and disputes are final

---

## Account Requirements

| Platform | Requirement |
|---|---|
| GitHub | Mandatory — same account used throughout |
| LeetCode | Mandatory — same account used throughout |
| HackerRank | Mandatory for Milestone Contests — must be registered with UPES email |

---

## Common Mistakes to Avoid

The following mistakes have come up repeatedly and affect scoring or automation. Please read these carefully.

**Repository structure issues**
- Your folder must be inside `DSA/` — placing it at the root level is incorrect
- Create only one personal folder — duplicate folders split your points
- Do not add sub-folders inside a day's folder — place solution files directly inside `Day_1/`, `Day_2/`, etc.

**Submission issues**
- Both questions must be present — a day with only one question submitted is marked incomplete
- An empty folder (folder exists but contains no file) does not count as a submission
- Do not upload multiple copies of the same solution with names like `solution_v2.cpp` or `final_final.py`

**Pull Request issues**
- Opening a PR and forgetting to raise it is the most common oversight — committing to your fork does not create a PR automatically
- Do not open multiple PRs for the same day — if you need to add or fix something, push to the existing PR
- Ensure the PR title follows the required format; untitled or misformatted PRs may not be attributed to your account

**Merge conflicts**
- If your PR shows merge conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`), resolve them before pushing. Files with unresolved markers cannot be evaluated.

---

## Questions and Support

For any queries regarding the challenge, reach out to the UPES ACM or ACM-W Student Chapter through the official communication channels announced during the GitHub Workshop.

---

*UPES ACM and ACM-W Student Chapters — 100 Days of Code 2026*
