package org.gradle.hackathon

import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.request.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.css.Color
import kotlinx.css.backgroundColor
import kotlinx.css.height
import kotlinx.css.px
import kotlinx.css.width
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.gradle.hackathon.ui.BootstrapButton
import org.gradle.hackathon.ui.BootstrapFormControl
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.createRef
import react.dom.render
import react.setState
import styled.css
import styled.styledDiv

fun main() {
    render(document.getElementById("app")) {
        child(IndexPage::class) {}
    }
}

class IndexPage : RComponent<RProps, IndexPageState>() {
    private val numberInput = createRef<dynamic>()
    override fun IndexPageState.init() {
        shapes = emptyList()
    }

    override fun RBuilder.render() {
        +"How many shapes would you like to load?"
        BootstrapFormControl {
            attrs.type = "number"
            attrs.placeholder = "how many?"
            attrs.ref = numberInput
        }
        BootstrapButton {
            attrs.size = "sm"
            attrs.onClick = {
                GlobalScope.launch {
                    val client = HttpClient(Js)
                    val response = client.post<String>(
                        port = window.location.port.toInt(),
                        path = "/data",
                        body = JSON.stringify(RequestParam(numberInput.current.value))
                    ) {
                        header("Content-Type", "application/json")
                        header("Accept", "application/json")
                    }
                    setState {
                        shapes = Json.decodeFromString(response)
                    }
                }
            }
            +"loadData"
        }
        state.shapes.forEach { shape ->
            styledDiv {
                css {
                    width = shape.width.px
                    height = shape.height.px
                    backgroundColor = Color(shape.color)
                }
            }
        }
    }
}

interface IndexPageState : RState {
    var shapes: List<Shape>
}
