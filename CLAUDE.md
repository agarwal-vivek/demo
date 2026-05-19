# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run

There is no build tool (no Maven, Gradle, or Ant). Compile and run directly with `javac`/`java`.

**Compile a single file (default package):**
```bash
javac FileName.java
java FileName
```

**Compile files that depend on each other (e.g. MaxInTree needs BinaryTree, TreeNode, MyStackImpl):**
```bash
javac MyStackImpl.java TreeNode.java BinaryTree.java MaxInTree.java
java MaxInTree
```

**Compile a package (tree or Graph):**
```bash
javac tree/*.java        # from repo root, if sources were in subdirs — currently all in root
```
Since all `.java` files sit flat in the repo root, compile the dependency chain manually or use a wildcard:
```bash
javac *.java
java <ClassName>
```

There are no tests.

## Architecture & Structure

### Package layout (logical, all files are in the repo root)

| Package | Files |
|---------|-------|
| `(default)` | Most algorithm/array/string/heap classes |
| `tree` | `BasicTreeQuestion`, `FindMaxRecursion`, `LongestPath`, `MaxPathSum`, `ValidatePathForGivenSum`, `printAllAncestor`, `printMax`, `printPathWithGivenSum`, `iterator` |
| `Graph` | `BreathFirstTraversal`, `DepthFirstRecursive`, `DepthFirstTraversal` |

### Shared infrastructure classes

These are referenced by many other classes and must be compiled first:

- **`TreeNode`** — generic binary tree node (`iData`, `leftChild`, `rightChild`) with getters/setters. Used by all `Tree*` classes in the default package.
- **`MyStackImpl`** — array-backed stack used by `BinaryTree`, `MaxInTree`, `TreeBoundyTraverse`, `TreePrintByLevel`, `TreePrintSpiral`, `PrintTreeAllroute`.
- **`BinaryTree`** — builds a random BST and exposes `makeTree()` / `getBinaryTree()`. Used by `MaxInTree`, `TreeBoundyTraverse`, `TreePrintByLevel`, `TreePrintSpiral`, `PrintTreeAllroute`.

### Local inner classes

Several files declare their own local `Node` inner class (incompatible with `TreeNode`):
- `tree` package files: `BasicTreeQuestion`, `FindMaxRecursion`, `LongestPath`, `MaxPathSum`, `ValidatePathForGivenSum`, `printAllAncestor`, `printMax`, `printPathWithGivenSum`

Other files define auxiliary classes in the same file:
- `BreathFirstTraversal.java` → `Graph`
- `DepthFirstRecursive.java` → `DFSG`
- `DepthFirstTraversal.java` → `DFSGraph`
- `MergeInterval.java` → `Interval`
- `CustomLRU.java` → `LRUCache`, `node`
- `OptionalDemo.java` → `student`
- `DemoHeap.java` → `Customheap`

### Topic groupings

- **Trees (default package, uses TreeNode/BinaryTree):** `MaxInTree`, `TreeBoundyTraverse`, `TreePrintByLevel`, `TreePrintSpiral`, `PrintTreeAllroute`
- **Trees (tree package, local Node):** `BasicTreeQuestion`, `FindMaxRecursion`, `LongestPath`, `MaxPathSum`, `ValidatePathForGivenSum`, `printAllAncestor`, `printMax`, `printPathWithGivenSum`
- **Graphs:** `BreathFirstTraversal` (BFS), `DepthFirstTraversal` (iterative DFS), `DepthFirstRecursive` (recursive DFS), `GraphDemo`
- **Sorting:** `QuickSort`, `SortPosNeg`, `sort012`, `MergeInterval`
- **Arrays:** `MergeTwoSortedArray`, `MergeTwoSortedArrayWithoutExtraSpace`, `IntersectionTwoSortedArray`, `InversionCount`, `KthMaxMin`, `largestSumSubArray`, `FndMaxMin`, `ReverseArrayRecursion`, `RemoveDuplicate`, `StockBuySell`
- **Dynamic programming:** `LIS`, `MinJump`, `MinJumpToReachEnd`
- **Heap:** `heapify`, `DemoHeap`, `CustomLRU`
- **Strings/misc:** `CountAndSay`, `PrintAllCombination`, `PrintAllStringPermutation`, `BowlingRating`, `RomanToNumber`
