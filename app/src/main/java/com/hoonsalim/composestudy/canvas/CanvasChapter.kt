package com.hoonsalim.composestudy.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.hoonsalim.composestudy.Chapter
import com.hoonsalim.composestudy.R
import com.hoonsalim.composestudy.ui.components.TitleAndRow
import java.lang.Math.PI
import java.lang.Math.sin

class CanvasChapter: Chapter {
    override val titleStringResourceId: Int = R.string.canvas
    override val destination: String = "canvas"

    @Composable
    override fun Page() {
        LazyColumn(

        ){
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawImage"
                ){
                    DrawImage()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawPoints"
                ){
                    DrawPoints()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawPath"
                ){
                    DrawPath()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawArc"
                ){
                    DrawArc()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "ShadowCircle"
                ){
                    ShadowCircle()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "RadialFill"
                ){
                    RadialFill()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "GradientFill"
                ){
                    GradientFill()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawOval"
                ){
                    DrawOval()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawCircle"
                ){
                    DrawCircle()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawRect"
                ){
                    DrawRect()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawRect2"
                ){
                    DrawRect2()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawLine1"
                ){
                    DrawLine()
                }
            }
            item {
                TitleAndRow(
                    modifier = Modifier.fillMaxWidth(),
                    title = "DrawLine2"
                ){
                    DrawLine2()
                }
            }
        }
    }

    @Composable
    private fun DrawImage() {
        val image = ImageBitmap.imageResource(id = R.drawable.vacation)

        Canvas(
            modifier = Modifier.size(360.dp)
        ) {
            val height = this@Canvas.size.height
            val width = this@Canvas.size.width

            println("height == $height, width == $width")
            drawImage(
                image = image,
                topLeft = Offset(x = 0f, y = 0f),
                colorFilter = ColorFilter.tint(
                    color = Color(0xADFFAA2E),
                    blendMode = BlendMode.ColorBurn
                )
            )
        }
    }

    @Composable
    private fun DrawPoints() {
        Canvas(modifier = Modifier.size(300.dp)) {

            val height = size.height
            val width = size.width

            val points = mutableListOf<Offset>()

            for (x in 0..size.width.toInt()) {
                val y = (sin(x * (2f * PI /   width))
                        * (height / 2) + (height / 2)).toFloat()
                points.add(Offset(x.toFloat(), y))
            }
            drawPoints(
                points = points.filterIndexed { index, _ -> index % 2 == 0 },
                strokeWidth = 3f,
                pointMode = PointMode.Polygon,
                color = Color.Blue
            )
        }
    }

    @Composable
    private fun DrawPath() {
        Canvas(modifier = Modifier.size(300.dp)) {

            val x1 = 50.dp.toPx()
            val y1 = 200.dp.toPx()
            val x2 = 300.dp.toPx()
            val y2 = 300.dp.toPx()

            val path = Path().apply {
                moveTo(0f, 0f)
                quadraticBezierTo(
                    x1 = x1,
                    y1 = y1,
                    x2 = x2,
                    y2 = y2
                )
                lineTo(270.dp.toPx(), 100.dp.toPx())
                quadraticBezierTo(60.dp.toPx(), 80.dp.toPx(), 0f, 0f)
                close()
            }

            //x1
            drawCircle(
                color = Color.Red,
                center = Offset(x1, y1),
                radius = 10f
            )

            //x2
            drawCircle(
                color = Color.Magenta,
                center = Offset(x2, y2),
                radius = 10f
            )

            drawPath(
                path = path,
                Color.Blue,
            )
        }
    }

    @Composable
    private fun DrawArc() {
        Canvas(modifier = Modifier.size(300.dp)) {
            drawArc(
                Color.Blue,
                startAngle = 0f,
                sweepAngle = 355f,
                useCenter = true,
                size = Size(250.dp.toPx(), 250.dp.toPx())
            )
        }
    }

    @Composable
    private fun ShadowCircle() {
        Canvas(modifier = Modifier.size(300.dp)) {
            val radius = 150.dp.toPx()
            val colorList: List<Color> =
                listOf(Color.Blue, Color.Black)

            val brush = Brush.horizontalGradient(
                colors = colorList,
                startX = 0f,
                endX = 300.dp.toPx(),
                tileMode = TileMode.Repeated
            )

            drawCircle(
                brush = brush,
                radius = radius
            )
        }
    }

    @Composable
    private fun RadialFill() {
        Canvas(modifier = Modifier.size(300.dp)) {

            val canvasWidth = size.width
            val canvasHeight = size.height
            val radius = 150.dp.toPx()
            val colorList: List<Color> = listOf(Color.Red, Color.Blue,
                Color.Magenta, Color.Yellow, Color.Green, Color.Cyan)

            val brush = Brush.radialGradient(
                colors = colorList,
                center = center,
                radius = radius,
                tileMode = TileMode.Repeated
            )

            drawCircle(
                brush = brush,
                center = center,
                radius = radius
            )
        }
    }

    @Composable
    private fun GradientFill() {

        Canvas(modifier = Modifier.size(300.dp)) {
            val canvasSize = size
            val colorList: List<Color> = listOf(Color.Red, Color.Blue,
                Color.Magenta, Color.Yellow, Color.Green, Color.Cyan)

            val brush = Brush.horizontalGradient(
                colors = colorList,
                startX = 0f,
                endX = 150.dp.toPx(),
                tileMode = TileMode.Repeated
            )

            drawRect(
                brush = brush,
                size = canvasSize
            )
        }
    }

    @Composable
    private fun DrawOval() {
        Canvas(modifier = Modifier.size(300.dp)) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawOval(
                color = Color.Blue,
                topLeft = Offset(x = 25.dp.toPx(), y = 90.dp.toPx()),
                size = Size(
                    width = canvasHeight - 50.dp.toPx(),
                    height = canvasHeight / 2 - 50.dp.toPx()
                ),
                style = Stroke(width = 12.dp.toPx())
            )
        }
    }

    @Composable
    private fun DrawCircle() {
        Canvas(modifier = Modifier.size(300.dp)) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawCircle(
                color = Color.Blue,
                center = center,
                radius = 120.dp.toPx()
            )
        }
    }

    @Composable
    private fun DrawRect() {
        Canvas(
            modifier = Modifier.size(300.dp).background(Color.Yellow)
        ) {
            val x = size.height/2f
            val y = size.width/2f
            val topCenter = Offset(x, y)

            rotate(0f) {
                drawCircle(
                    color = Color.Red,
                    center = topCenter,
                    radius = 10f
                )
                drawRect(
                    color = Color.Blue,
                    topLeft = topCenter,
                    size = size / 2f
                )
            }
        }
    }

    @Composable
    private fun DrawRect2() {
        Canvas(
            modifier = Modifier.size(300.dp).background(Color.Yellow)
        ) {
            val x = size.height/2f
            val y = size.width/2f
            val topCenter = Offset(x, y)

            drawRoundRect(
                color = Color.Blue,
                topLeft = topCenter,
                size = size / 2f,
                cornerRadius = CornerRadius(
                    x = 30.dp.toPx(),
                    y = 30.dp.toPx(),
                )
            )
        }
    }

    @Composable
    private fun DrawLine() {
        Canvas(modifier = Modifier.size(300.dp)) {
            val height = size.height
            val width = size.width

            drawLine(
                start = Offset(x= 0f, y = 0f),
                end = Offset(x = width, y = height),
                color = Color.Blue,
                strokeWidth = 16.0f,
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(30f, 10f, 10f, 10f),
                    phase = 0.5f
                )
            )
        }
    }

    @Composable
    private fun DrawLine2() {
        Canvas(modifier = Modifier.size(300.dp)) {
            val height = size.height
            val width = size.width

            drawLine(
                start = Offset(x= 0f, y = 0f),
                end = Offset(x = width, y = height),
                color = Color.Blue,
                strokeWidth = 16.0f,
            )
        }
    }
}