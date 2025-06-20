//> using scala 3.3.6
//> using platform scala-native
//> using nativeVersion 0.5.8
//> using scalacOptions -Wconf:msg=indented:silent
//> using dep "io.github.finochiom:s2d_native0.5_3:0.1.6"

package sandbox

import s2d.core.{Window, Drawing}
import s2d.shapes.Basics
import s2d.textures.Textures
import s2d.types.*
import scalanative.unsafe.*
import scalanative.unsigned.*

@main
def main(): Unit =
  Window.create(800, 600, "S2D Framework - Images Module Test")

  val camera2D = Camera2D(
    offset = Vector2(0.0f, 0.0f),
    target = Vector2(0.0f, 0.0f),
    rotation = 0.0f,
    zoom = 1.0f
  )

  val textureOpt = Textures.load("assets/grill.png")

  val rect = Rectangle(400, 300, 100, 200)

  while !Window.shouldCloseWindow() do
    Drawing.beginFrame()
    Drawing.clear(Color.fromHex("#3498DB").getOrElse(Color.Blue))

    Drawing.beginCamera(camera2D)

    textureOpt match
      case Some(texture) =>
        Textures.draw(texture, 100, 100, Color.White)
      case None =>
        Basics.rectangle(rect, Color.Red)

    Drawing.endCamera()
    Drawing.endFrame()
  end while

  Window.close()
end main
