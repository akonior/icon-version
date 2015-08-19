package pl.itako.iconversion

import spock.lang.Specification

import java.awt.Color;

public class IconVersionConfigTest extends Specification {

    def "test getBackgroundOverlayColor"() {
        given:
        def input = new IconVersionConfig()
        input.backgroundOverlayColor = [255, 255, 255, 255]

        when:
        def color = input.getBackgroundOverlayColor()

        then:
        Color.WHITE.equals(color)
    }

    def "test getBackgroundOverlayColorWithInputTooSmall"() {
        given:
        def input = new IconVersionConfig()
        input.backgroundOverlayColor = [255]

        when:
        def color = input.getBackgroundOverlayColor()

        then:
        color.equals(IconVersionConfig.TRANSPARENT)
    }

    def "test getBackgroundOverlayColorWithInputTooBig"() {
        given:
        def input = new IconVersionConfig()
        input.backgroundOverlayColor = [255, 255, 255, 255, 255]

        when:
        def color = input.getBackgroundOverlayColor()

        then:
        color.equals(IconVersionConfig.TRANSPARENT)
    }

    def "test getBackgroundOverlayColorWithNullInput"() {
        given:
        def input = new IconVersionConfig()
        input.backgroundOverlayColor = null

        when:
        def color = input.getBackgroundOverlayColor()

        then:
        color.equals(IconVersionConfig.TRANSPARENT)
    }

    def "test getTextColor"() {
        given:
        def input = new IconVersionConfig()
        input.textColor = [0, 0, 0, 255]

        when:
        def color = input.getTextColor()

        then:
        Color.BLACK.equals(color)
    }

    def "test getTextColorWithInputTooSmall"() {
        given:
        def input = new IconVersionConfig()
        input.textColor = [255]

        when:
        def color = input.getTextColor()

        then:
        color.equals(IconVersionConfig.TRANSPARENT)
    }

    def "test getTextColorWithInputTooBig"() {
        given:
        def input = new IconVersionConfig()
        input.textColor = [255, 255, 255, 255, 255]

        when:
        def color = input.getTextColor()

        then:
        color.equals(IconVersionConfig.TRANSPARENT)
    }

    def "test getTextColorWithNullInput"() {
        given:
        def input = new IconVersionConfig()
        input.textColor = null

        when:
        def color = input.getTextColor()

        then:
        color.equals(IconVersionConfig.TRANSPARENT)
    }
}
