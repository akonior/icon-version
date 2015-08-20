icon-version
============

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-icon--version-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1121)

Android gradle plugin that adds version and flavor name to all debug icons.

```groovy
buildscript {
  repositories {
    mavenCentral()
    jcenter()
  }

  dependencies {
    classpath 'pl.itako:icon-version:1.1.+'
  }
}

apply plugin: 'com.android.application'
apply plugin: 'icon-version'
```

When you apply the plugin and install an app all debug version icons will have flavour, build type and version name.

The customisation options can be applied in the app build.gradle as such:

```
iconVersionConfig {
    fontSize = 10
    textColor = [0, 255, 0, 255] // [r, g, b, a]
    verticalLinePadding = 4 // vertical gap between each line of text
    backgroundOverlayColor = [255, 0, 0, 255]  // [r, g, b, a]
}
```

![Screenshot](doc/icon-version-screenshot.png)

License
--------

Copyright 2014 Arkadiusz Konior

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
