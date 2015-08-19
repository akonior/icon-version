package pl.itako.iconversion

import java.awt.Color

/**
 * Holds various configuration options which control how to overlaid information is drawn
 */
class RenderingConfig {

    static final int DEFAULT_FONT_SIZE = 14
    static final int DEFAULT_VERTICAL_LINE_PADDING = 4
    static final Color DEFAULT_BACKGROUND_COLOR = new Color(0, 0, 0, 136)
    static final Color DEFAULT_TEXT_COLOR = Color.WHITE

    static final RenderingConfig DEFAULT = new RenderingConfig()

    int fontSize;

    int verticalLinePadding;

    Color backgroundOverlayColor;

    Color textColor;

    RenderingConfig() {
        fontSize = DEFAULT_FONT_SIZE;
        verticalLinePadding = DEFAULT_VERTICAL_LINE_PADDING;
        backgroundOverlayColor = DEFAULT_BACKGROUND_COLOR;
        textColor = DEFAULT_TEXT_COLOR;
    }

}