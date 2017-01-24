package pl.itako.iconversion

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.api.BaseVariant
import com.android.build.gradle.api.BaseVariantOutput
import com.android.build.gradle.tasks.ProcessAndroidResources
import org.gradle.api.Plugin
import org.gradle.api.Project

import static pl.itako.iconversion.IconUtils.addTextToImage
import static pl.itako.iconversion.IconUtils.findIcons

class IconVersionPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        if (!project.plugins.hasPlugin(AppPlugin)) {
            throw new IllegalStateException("'android' plugin required.")
        }

        // Register extension to allow users to customize
        IconVersionConfig config = project.extensions.create("iconVersionConfig", IconVersionConfig)

        def log = project.logger
        project.android.applicationVariants.all { BaseVariant variant ->

            // Dont want to modify release builds
            if (!variant.buildType.debuggable) {
                log.info "IconVersionPlugin. Skipping non-debuggable variant: $variant.name"
                return
            }

            def lines = []
            if (config.shouldDisplayBuildName) {
                lines.push(variant.flavorName + " " + variant.buildType.name)
            }
            if (config.shouldDisplayVersionName) {
                lines.push(variant.versionName)
            }

            log.info "IconVersionPlugin. Processing variant: $variant.name"
            variant.outputs.each { BaseVariantOutput output ->
                output.processResources.doFirst {
                    ProcessAndroidResources task = delegate
                    variant.outputs.each { BaseVariantOutput variantOutput ->
                        File manifest = output.processManifest.manifestOutputFile

                        File resDir = task.resDir
                        log.info "Looking for icon files in: $resDir.absolutePath"

                        findIcons(resDir, manifest).each { File icon ->
                            log.info "Adding build information to: " + icon.absolutePath

                            addTextToImage(icon, config, *lines)
                        }
                    }
                }
            }
        }
    }
}
