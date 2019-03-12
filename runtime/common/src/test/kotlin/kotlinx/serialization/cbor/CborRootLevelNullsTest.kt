/*
 * Copyright 2017-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.serialization.cbor

import kotlinx.serialization.*
import kotlinx.serialization.internal.*
import kotlin.test.*

class CborRootLevelNullsTest {
    @Serializable
    data class Simple(val a: Int = 42)

    @Test
    fun testNull() {
        val obj: Simple? = null
        val content = (Cbor as BinaryFormat).dump(makeNullable(Simple.serializer()), obj)
        assertTrue(content.contentEquals(byteArrayOf(0xf6.toByte())))
    }
}
