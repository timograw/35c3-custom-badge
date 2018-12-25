package de.timograw.badge35c3.constants

import android.graphics.Rect
import de.timograw.badge35c3.elements.CharacterInfo

object Memories {

    const val top = 1150
    const val height = 190

    val characterInfos = listOf(
        CharacterInfo('M', top,0, 210, height),
        CharacterInfo('E', top, 230, 100, height),
        CharacterInfo('M', top, 350, 150, height),
        CharacterInfo('O', top, 510, 130, height),
        CharacterInfo('R', top, 660, 100, height),
        CharacterInfo('I', top, 780, 50, height),
        CharacterInfo('E', top, 860, 110, height),
        CharacterInfo('S', top, 980, 100, height)
    )

    val characterCount = characterInfos.count()

    val characterRects = characterInfos.map {
        Rect(it.left, it.top, it.left + it.width, it.top + it.height)
    }

}