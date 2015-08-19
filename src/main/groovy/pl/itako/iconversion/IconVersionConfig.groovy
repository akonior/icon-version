package pl.itako.iconversion

import java.awt.Color

/**
 * Allow users of this extension to customize properties of their builds
 */
class IconVersionConfig {

    /**
     * The size of the text to draw on top of the icon
     */
    int fontSize = 12

    /**
     * The amount of vertical space between each line of text
     */
    int verticalLinePadding = 4

    /**
     * Text color to draw behind the text
     */
    int[] backgroundOverlayColor = [0, 0, 0, 136]

    /**
     * The text color to draw the overlaid text.
     */
    int[] textColor = [255, 255, 255, 255]

    public Color getBackgroundOverlayColor() {
        return intArrayToColor(backgroundOverlayColor) ?: Color.TRANSPARENT
    }

    public Color getTextColor() {
        return intArrayToColor(textColor) ?: Color.WHITE
    }

    private static Color intArrayToColor(int[] colorParts) {
        if (colorParts == null || colorParts.length != 4) {
            return null;
        } else {
            return new Color(colorParts[0], colorParts[1], colorParts[2], colorParts[3])
        }
    }
}