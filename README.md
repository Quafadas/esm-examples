# esm-examples
Example of using ESM modules to avoid bundling in scala JS

## Project Structure

This is a single module Mill build with Scala.js configured to output ESM modules.

```
site/
├── src/           # Scala source files
│   └── example.scala
├── resources/     # Resource files
│   └── test.csv
└── docs/          # Documentation
    └── test.md
```

## Prerequisites

- Java 11 or higher
- Mill build tool (bootstrap script included)

## Getting Started

### Using Mill

The repository includes Mill's bootstrap script (`mill`) which will automatically download and use the version specified in `.mill-version` (1.0.6).

Simply run:
```bash
./mill site.compile
```

The first time you run Mill, it will download the necessary binaries.

### Building

Compile the project:
```bash
./mill site.compile
```

Generate JavaScript (development mode with ESM):
```bash
./mill site.fastLinkJS
```

Generate optimized JavaScript (production mode):
```bash
./mill site.fullLinkJS
```

### IDE Support (Metals)

This project is configured for use with Metals (Scala language server).

To set up Metals in your editor:
```bash
./mill mill.bsp.BSP/install
```

The `.scalafmt.conf` file provides formatting configuration for Metals.

## Module Configuration

The `site` module is configured as a Scala.js module with:
- Scala version: 3.3.1
- Scala.js version: 1.15.0
- Module kind: ESModule (to avoid bundling)
- Mill version: 1.0.6 (specified in YAML frontmatter in build.mill)

The ESModule output allows you to use native ES6 imports in the browser without bundling.
