package pl.itako.iconversion

import spock.lang.Specification

import static pl.itako.iconversion.IconUtils.addTextToImage
import static pl.itako.iconversion.IconUtils.findIcons
import static pl.itako.iconversion.IconUtils.getIconName

class IconUtilsTest extends Specification {

    def "test getIconName"() {
        given:
        def file = getClass().getResource('/AndroidManifest.xml').file

        when:
        String iconName = getIconName(new File(file))

        then:
        "ic_launcher".equals(iconName)
    }

    def "test getIconNameWithNoIconDefined"() {
        given:
        def file = getClass().getResource('/AndroidManifest_noIcon.xml').file

        when:
        String iconName = getIconName(new File(file))

        then:
        iconName == null
    }

    def "test getIconNameWithNullManifest"() {
        given:
        def file = null as File

        when:
        String iconName = getIconName(file)

        then:
        iconName == null
    }

    def "test addWatermark"() {
        given:
        InputStream is = getClass().getResourceAsStream('/test_icons/drawable-xxhdpi/ic_launcher.png')

        def file = new File('/tmp/out.png')
        def stream = new FileOutputStream(file)
        stream.write(is.bytes)
        stream.close()

        when:
        addTextToImage(file, "demo debug", "1.2.34")

        then:
        file.exists()
    }

    def 'test findIconsIfNotSpecifiedInManifest'() {
        given:
        URL url = getClass().getResource('/test_icons')
        def dir = url.file

        when:
        List<File> icons = findIcons(new File(dir), null)

        then:
        icons.size() == 4
    }

    def 'test findIconsFromManifest'() {
        given:
        def dir = getClass().getResource('/test_icons').file
        def manifestFile = getClass().getResource('/AndroidManifest.xml').file

        when:
        List<File> icons = findIcons(new File(dir), new File(manifestFile))

        then:
        icons.size() == 4
    }
}
