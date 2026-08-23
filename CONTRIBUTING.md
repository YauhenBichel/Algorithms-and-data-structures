# Contributing

Thanks for considering a contribution. This is a reference collection of **algorithms and data
structures in Java** — 928 implementations filed by the technique they use, with a
[documentation site](https://yauhenbichel.github.io/Algorithms-and-data-structures/) covering the
core ones in depth.

Contributions of every size are welcome, including a typo fix.

---

## Quick start

```bash
# 1. Fork on GitHub, then clone your fork
git clone https://github.com/<your-username>/Algorithms-and-data-structures.git
cd Algorithms-and-data-structures

# 2. Branch
git checkout -b add-dijkstra-tests

# 3. Verify the build works before you change anything
./gradlew compileJava compileTestJava
./gradlew test

# 4. Make your change, then push and open a pull request against master
git push origin add-dijkstra-tests
```

You need a JDK 17; the Gradle wrapper handles everything else.

> **If you cannot fork.** Some corporate GitHub accounts block fork creation. Say so in an issue
> and a maintainer will create a branch on this repository for you to push to. Please do not send
> patches by email — a Java test file executes arbitrary code during `./gradlew test`, so changes
> need to arrive as a reviewable diff that CI has seen.

---

## Two things worth knowing before you start

**1. Eight tests currently fail on `master`.** `./gradlew test` reports 58 passed, 8 failed. These
predate your change — see [issue #3](https://github.com/YauhenBichel/Algorithms-and-data-structures/issues/3).
If you see those eight fail, that is expected and not caused by your work.

**2. Most existing tests do not assert anything.** 40 of 54 test files call `System.out.println`
and never assert, so they pass regardless of whether the algorithm is correct:

```java
// This is NOT a test. It always passes.
@Test
public void test1() {
    NumberOfIslands pr = new NumberOfIslands();
    System.out.println(pr.numIslands(grid));   // prints, asserts nothing
}
```

**New tests must assert.** Converting an existing print-only test into a real one is a genuinely
useful contribution.

---

## Ways to help

| | |
|---|---|
| **Add real tests** | The highest-value work here. 928 implementations, ~14 files with actual assertions |
| **Fix a failing test** | [Issue #3](https://github.com/YauhenBichel/Algorithms-and-data-structures/issues/3) — decide whether the test or the implementation is wrong, and say which |
| **Add a documentation page** | [Issue #2](https://github.com/YauhenBichel/Algorithms-and-data-structures/issues/2) — the site covers 22 of many |
| **Add a missing algorithm** | With a complexity note |
| **Improve an explanation** | Clear reasoning about *why* a complexity holds is worth as much as the code |

---

## How to write a test here

Tests mirror the main source layout under `src/test/java/`. Use JUnit 5.

```java
package com.bichel.algorithms.graph;

import com.bichel.algorithms.problemsheap.graph.IsGraphBipartite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsGraphBipartiteTest {

    @Test
    public void returnsTrueForBipartiteGraph() {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        assertTrue(new IsGraphBipartite().isBipartite(graph));
    }

    @Test
    public void returnsTrueForEmptyGraph() {
        assertTrue(new IsGraphBipartite().isBipartite(new int[0][]));
    }

    @Test
    public void returnsFalseWhenAnyComponentHasAnOddCycle() {
        // Two components: 0-1-2 forms a triangle (odd cycle), 3-4 is fine.
        // Catches the classic bug of only checking the first component.
        int[][] graph = {{1, 2}, {0, 2}, {0, 1}, {4}, {3}};
        assertFalse(new IsGraphBipartite().isBipartite(graph));
    }
}
```

**What makes a good test here**

- **Assert.** `assertEquals`, `assertTrue`, `assertThrows` — never just print.
- **Cover the edge cases**, not only the happy path: empty input, a single element, and the case
  the algorithm most plausibly gets wrong (a disconnected graph, an already-sorted array, duplicates).
- **Name the behaviour**, not the number — `returnsFalseWhenAnyComponentHasAnOddCycle` beats `test3`.
- **One algorithm per pull request.** Five small PRs are far easier to review than one sweep.

---

## Conventions

- Implementations live under `src/main/java/com/bichel/`, filed by **technique**, not by source —
  a sliding-window problem belongs in `problemsheap/sliding_window/` wherever it came from.
- State time and space complexity in a comment at the top of each implementation.
- Prefer clarity over cleverness. This is a reference people read.
- Match the surrounding style rather than reformatting whole files.

---

## Continuous integration

Every pull request runs:

| Check | Blocking | What it does |
|---|---|---|
| **Build** | ✅ | `./gradlew compileJava compileTestJava` on JDK 17 |
| **Secret scan** | ✅ | gitleaks over the full history |
| **Repository hygiene** | ✅ | Blocks credential files, committed build output, files over 2MB |
| **Tests** | ❌ *for now* | Runs JUnit and posts a pass/fail table to the run summary |

Tests are **reporting-only** because of the 8 pre-existing failures — blocking on them would reject
every contribution. Once [issue #3](https://github.com/YauhenBichel/Algorithms-and-data-structures/issues/3)
is closed this becomes a required check. Meanwhile the summary table lets a reviewer see whether
your PR changed the counts.

Checks run with **no repository secrets** and a read-only token. If you are a first-time
contributor, a maintainer approves the run before it starts — that is normal, not a problem with
your PR.

---

## Adding a documentation page

Create `docs/<slug>.md` following an existing page:

```markdown
---
title: "Algorithm Name in Java"
description: "One sentence including the complexity — this becomes the meta description."
category: "Graph Algorithms"
---
```

Then the explanation, a complexity table, the implementation, and a link to the source file.
Add a link from `docs/index.md`.

---

## Opening the pull request

1. Fill in the template — say what changed and why.
2. Link the issue it addresses (`Closes #1`).
3. Confirm `./gradlew compileTestJava` passes locally.
4. If new tests fail, say whether you believe the test or the implementation is wrong.

I read every pull request. If something needs changing I will say what and why; if I disagree with
an approach I will explain rather than close it silently. If a PR sits for more than a week, a
nudge in the thread is entirely reasonable.

---

## Ground rules

Be decent to each other — see [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md). Never commit credentials,
build output, or `.env` files; CI blocks these outright.

By contributing you agree that your work is licensed under the [MIT Licence](LICENSE).
