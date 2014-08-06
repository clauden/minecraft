Modding with Forge... a sign of the times.

$ mkdir work-dir
$ unzip -d . ~/Downloads/forge-1.7.2-10.12.2.1147-src.zip
$ ./gradlew setupDecompWorkspace --refresh-dependencies eclipse
$ git clone <this-repo> repo
$ cp -rp repo/mods/<some-mod>/* src/main
