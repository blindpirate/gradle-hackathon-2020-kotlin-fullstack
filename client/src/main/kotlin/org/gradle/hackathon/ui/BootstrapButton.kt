@file:JsModule("react-bootstrap/Button")
@file:JsNonModule
package org.gradle.hackathon.ui

import react.RClass
import react.RProps

@JsName("default")
external val BootstrapButton: RClass<BootstrapButtonProps>
external interface BootstrapButtonProps : RProps {
    var active: Boolean
    var disabled: Boolean
    var href: String
    var size: String
    var type: String
    var variant: String
    var onClick: Any
}
