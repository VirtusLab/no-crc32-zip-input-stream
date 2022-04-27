//> using scala "2.13.8"
//> using lib "com.lihaoyi::utest::0.7.10"
//> using lib "io.get-coursier:interface:1.0.7"

package io.github.scala_cli.zip

import coursierapi._
import utest._

import java.io.{FileInputStream, InputStream}
import java.util.zip.ZipEntry

import scala.collection.mutable

object CustomZipInputStreamTests extends TestSuite {
  val tests = Tests {
    test("simple test") {

      val cache = Cache.create()
      val f = cache.get(Artifact.of("https://repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.8/scala-library-2.13.8.jar"))

      var entries = new mutable.ListBuffer[(String, Int)]

      var is: InputStream = null
      try {
        is = new FileInputStream(f)
        val zis = new ZipInputStream(is)
        var ent: ZipEntry = null
        while ({
          ent = zis.getNextEntry()
          ent != null
        }) {
          val b = zis.readAllBytes()
          entries += ent.getName -> b.length
        }
      }
      finally {
        if (is != null)
          is.close()
      }

      val map = entries.toMap

      assert(map.get("scala/util/hashing/package.class").contains(792))
      assert(map.get("scala/util/Right.class").contains(5011))
    }
  }
}