import sbt.Keys.commands
import sbt._

object Foo extends AutoPlugin {
  override def requires: Plugins = Bar

  override def projectSettings =
    Seq(commands += Command.command("foo") { state =>
      println("foo")
      state
    })
}

object Bar extends AutoPlugin {
  override def requires: Plugins = Baz
  override def trigger = allRequirements

  override def projectSettings =
    Seq(commands += Command.command("bar") { state =>
      println("bar")
      state
    })
}

object Baz extends AutoPlugin {
  override def projectSettings =
    Seq(commands += Command.command("baz") { state =>
      println("baz")
      state
    })
}

object Hoge extends AutoPlugin {
  override def requires: Plugins = Foo
  override def trigger = allRequirements

  override def projectSettings =
    Seq(commands += Command.command("hoge") { state =>
      println("hoge")
      state
    })
}

object Piyo extends AutoPlugin {
  override def trigger = allRequirements

  object notAutoImport {
    val piyoCommand = Command.command("piyo") { state =>
      println("piyo")
      state
    }
  }
}

object Fuga extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    val fugaCommand = Command.command("fuga") { state =>
      println("fuga")
      state
    }
  }
}
