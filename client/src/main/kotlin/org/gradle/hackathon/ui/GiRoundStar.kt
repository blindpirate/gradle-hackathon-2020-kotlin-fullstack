@file:JsModule("react-icons/gi")
@file:JsNonModule

package org.gradle.hackathon.ui

import react.RClass
import react.RProps

// https://react-icons.github.io/react-icons/icons?name=gi

@JsName("GiRoundStar")
external val giRoundStar: RClass<IconProps>

external interface IconProps : RProps {
    var onClick: Any
    var style: Any
    var size: Int
}