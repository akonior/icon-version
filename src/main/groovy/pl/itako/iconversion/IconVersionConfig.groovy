package pl.itako.iconversion

import java.awt.Color

/**
 * Allow users of this extension to customize properties of their builds
 */
class IconVersionConfig {

    static DEFAULT = new IconVersionConfig()

    static TRANSPARENT = new Color(0, 0, 0, 0)

    /**
     * The size of the text to draw on top of the icon
     */
    int fontSize = 12

    /**
     * Build types for which the icon should be adapted.
    */
    String[] buildTypes = ["debug"]

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

    /**
     * Whether the build name (flavor + build type) should be printed.
     */
    boolean shouldDisplayBuildName = true;

    /**
     * Whether the version name should be printed.
     */
    boolean shouldDisplayVersionName = true;

    /**
     * Whether the version code should be printed.
    */
    boolean shouldDisplayVersionCode = false;

    public Color getBackgroundOverlayColor() {
        return intArrayToColor(backgroundOverlayColor) ?: TRANSPARENT
    }

    public Color getTextColor() {
        return intArrayToColor(textColor) ?: TRANSPARENT
    }

    private static Color intArrayToColor(int[] colorParts) {
        if (colorParts == null || colorParts.length != 4) {
            return null;
        } else {
            return new Color(colorParts[0], colorParts[1], colorParts[2], colorParts[3])
        }
    }
}
