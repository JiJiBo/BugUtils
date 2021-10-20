package com.rulerbug.bugutils.dsl

import android.text.Editable
import android.text.TextWatcher

private typealias after = (edit: Editable?) -> Unit
private typealias before = (chars: CharSequence?, start: Int, count: Int, after: Int) -> Unit
private typealias on = (chars: CharSequence?, start: Int, before: Int, count: Int) -> Unit

class BugWatcher : TextWatcher {
    private var after: after? = null
    private var before: before? = null
    private var on: on? = null

    fun after(after: after) {
        this.after = after
    }

    fun before(before: before) {
        this.before = before
    }

    fun on(on: on) {
        this.on = on
    }

    override fun beforeTextChanged(chars: CharSequence?, start: Int, count: Int, after: Int) {
        return before?.invoke(chars, start, count, after) ?: Unit
    }

    override fun onTextChanged(chars: CharSequence?, start: Int, before: Int, count: Int) {
        return on?.invoke(chars, start, before, count) ?: Unit
    }

    override fun afterTextChanged(edit: Editable?) {
        return after?.invoke(edit) ?: Unit
    }

}

fun bugWatcher(watcher: BugWatcher.() -> Unit) = BugWatcher().also(watcher)
