package de.timograw.badge35c3.constants

import android.graphics.Rect
import de.timograw.badge35c3.elements.CharacterInfo

object Refreshing {

    const val top = 470
    const val height = 190
    const val bottom = top + height

    val characterInfos = listOf(
        CharacterInfo('R', top, 0, 100, height),
        CharacterInfo('E', top, 120, 100, height),
        CharacterInfo('F', top, 220, 100, height),
        CharacterInfo('R', top, 330, 100, height),
        CharacterInfo('E', top, 440, 100, height),
        CharacterInfo('S', top, 550, 100, height),
        CharacterInfo('H', top, 660, 110, height),
        CharacterInfo('I', top, 780, 50, height),
        CharacterInfo('N', top, 840, 110, height),
        CharacterInfo('G', top, 960, 110, height)
    )

    val characterCount = characterInfos.count()

    val characterRects = characterInfos.map {
        Rect(it.left, it.top, it.left + it.width, it.top + it.height)
    }

}