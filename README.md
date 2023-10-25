# no-crc32-zip-input-stream

A copy of `ZipInputStream` from OpenJDK (11?), with CRC32 calculations disabled. See
[`VirtusLab/scala-cli#865`](https://github.com/VirtusLab/scala-cli/pull/865) and linked issues for context.

## How to use

Add the following dependency to your build:
```scala
ivy"org.virtuslab.scala-cli.zip-input-stream:zip-input-stream:0.1.0"
```

Then use `io.github.scala_cli.zip.ZipInputStream` instead of `java.util.zip.ZipInputStream`.

## Developer docs

*no-crc32-zip-input-stream* is built with [Scala CLI](https://github.com/VirtusLab/scala-cli).
