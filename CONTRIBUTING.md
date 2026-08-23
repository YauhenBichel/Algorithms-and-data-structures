# Contributing

Thanks for considering a contribution. This is a reference collection of algorithms and data
structures in Java — 928 implementations organised by the technique they use. Contributions of
every size are welcome.

## Ways to help

- **Add tests.** There are 928 implementations and 54 test classes. This is the single most
  useful thing anyone can do here — pick one algorithm and cover it properly.
- **Add a documentation page.** The [site](https://yauhenbichel.github.io/Algorithms-and-data-structures/)
  covers 22 algorithms so far. Adding one for an algorithm already implemented is a well-scoped
  first contribution.
- **Add a missing algorithm.** If a classic algorithm is absent, add it with a complexity note.
- **Fix a bug.** If an implementation is wrong or an edge case breaks it, a failing test plus the
  fix is the ideal pull request.
- **Improve an explanation.** Clear reasoning about *why* an algorithm has its complexity is worth
  as much as the code.

## Getting set up

```bash
./gradlew build     # compile
./gradlew test      # run the JUnit 5 suite
```

You need a JDK; the Gradle wrapper handles the rest.

## Conventions

- Implementations live under `src/main/java/com/bichel/`, filed by **technique**, not by source —
  a sliding-window problem belongs in `problemsheap/sliding_window/`, wherever it came from.
- Tests mirror that layout under `src/test/java/`.
- State the time and space complexity in a comment at the top of each implementation.
- Prefer clarity over cleverness. This is a reference people read, not a golf course.

## Making a change

1. Fork and branch: `git checkout -b add-dijkstra-tests`
2. Keep the pull request to one algorithm or one concern. Five small PRs beat one large one.
3. Make sure `./gradlew test` passes.
4. Open a pull request and fill in the template.

## Adding a documentation page

Create `docs/<slug>.md` following an existing page:

```markdown
---
title: "Algorithm Name in Java"
description: "One sentence including the complexity — this becomes the page's meta description."
category: "Graph Algorithms"
---
```

Then the explanation, a complexity table, the implementation and a link to the source file.
Add a link from `docs/index.md`.

## Ground rules

Be decent to each other — see [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md).

By contributing you agree that your work is licensed under the [MIT Licence](LICENSE).
