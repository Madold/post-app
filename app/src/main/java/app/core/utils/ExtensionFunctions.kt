package app.core.utils

fun String.removeFirstAndLastChar(): String {
    return this.substring( 1, this.length - 1 )
}