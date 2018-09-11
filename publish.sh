#!/usr/bin/env bash
. ~/.bash_profile

./gradlew clean assembleDebug install
./gradlew bintrayUpload