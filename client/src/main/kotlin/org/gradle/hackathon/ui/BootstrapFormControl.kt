@file:JsModule("react-bootstrap/FormControl")
@file:JsNonModule

package org.gradle.hackathon.ui

import react.RClass
import react.RProps

@JsName("default")
external val BootstrapFormControl: RClass<BootstrapFormControlProps>

external interface BootstrapFormControlProps : RProps {
    var `as`: Any
    var ariaDescribedby: String
    var type: String
    var placeholder: String
    var ref: Any
}
