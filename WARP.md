# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

Repository summary
- Name: de-0-a-master-en-java
- Purpose: mi ruta de aprendizaje en java iniciando desde 0
- Build tooling: none (plain Java). No Maven/Gradle config present.
- Tests/lint: not configured.

Common commands (Windows PowerShell)
Prerequisite: Java JDK installed and available on PATH (javac and java).

- Clean build output

```powershell
# Remove compiled classes
if (Test-Path .output) { Remove-Item -Recurse -Force .output }
```

- Compile sources into .output

```powershell
# Ensure output dir and compile main file + utils package
New-Item -ItemType Directory -Force .output | Out-Null
javac -d .output Main.java src/main/java/io/github/theca/utils/*.java
```

- Run programs (entry points)

```powershell
# Root-level Main (default package)
java -cp .output Main

# Utilities (packaged under io.github.theca.utils)
java -cp .output io.github.theca.utils.HolaMundo
java -cp .output io.github.theca.utils.Primitivos
java -cp .output io.github.theca.utils.PrimitivosAsistente
java -cp .output io.github.theca.utils.variables
```

Notes
- The .output directory is used for compiled .class files. javac -d .output creates package directories as needed.
- PrimitivosAsistente is interactive and reads from standard input.
- There is currently no test framework (e.g., JUnit) in use and no linter/formatter configured.

High-level architecture
- Single-module, plain Java repository focused on small console programs.
- Entry points:
  - Main.java at repository root (default package). The body of main contains commented reference logic; adjust as needed before use.
  - Multiple independent examples in package io.github.theca.utils under src/main/java/io/github/theca/utils/:
    - HolaMundo: text animations and printing examples.
    - Primitivos: prints information about Java primitive types.
    - PrimitivosAsistente: prompts for user input and suggests an appropriate primitive type.
    - variables: String operations and character iteration examples.
- No external dependencies and no build tool configuration. Source compiles directly with javac, and programs run with java -cp .output <FullyQualifiedClass>.

How to extend
- To add a new example with a main method in the same package, place it under src/main/java/io/github/theca/utils/, re-run the compile command above, and then run it via java -cp .output io.github.theca.utils.YourClass.
