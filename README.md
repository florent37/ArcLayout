# ArcLayout

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ArcLayout-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/4694)

With Arc Layout explore new styles and approaches on material design

<a target='_blank' rel='nofollow' href='https://app.codesponsor.io/link/iqkQGAc2EFNdScAzpwZr1Sdy/florent37/ArcLayout'>
  <img alt='Sponsor' width='888' height='68' src='https://app.codesponsor.io/embed/iqkQGAc2EFNdScAzpwZr1Sdy/florent37/ArcLayout.svg' />
</a>

<a href="https://play.google.com/store/apps/details?id=com.github.florent37.florent.champigny">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

[![screen](https://raw.githubusercontent.com/florent37/ArcLayout/master/media/video1.gif)](https://www.github.com/florent37/ArcLayout)

# Usage

```xml
<com.github.florent37.arclayout.ArcLayout
         android:layout_width="match_parent"
         android:layout_height="200dp"
         app:arc_cropDirection="cropOutside|cropInside"
         app:arc_position="bottom|top|left|right"
         app:arc_height="90dp"
         android:elevation="5dp"
         >

         <!-- YOUR CONTENT -->

</com.github.florent37.arclayout.ArcLayout>
```

# Sample

## Crop Outside

```xml
<com.github.florent37.arclayout.ArcLayout
          android:layout_width="match_parent"
          android:layout_height="200dp"
          app:arc_cropDirection="cropOutside"
          app:arc_height="90dp"
          app:arc_padding="30dp"
          android:elevation="5dp"
          >
 
          <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:scaleType="centerCrop"
                android:src="@drawable/road" /> 
                
 </com.github.florent37.arclayout.ArcLayout>        
```

[![screen](https://raw.githubusercontent.com/florent37/ArcLayout/master/media/outside_small.png)](https://www.github.com/florent37/ArcLayout)

## Crop Inside

```xml
<com.github.florent37.arclayout.ArcLayout
          android:layout_width="match_parent"
          android:layout_height="200dp"
          app:arc_cropDirection="cropInside"
          app:arc_height="90dp"
          app:arc_padding="30dp"
          android:elevation="5dp"
          >
 
          <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:scaleType="centerCrop"
                android:src="@drawable/road" /> 
                
 </com.github.florent37.arclayout.ArcLayout>        
```

[![screen](https://raw.githubusercontent.com/florent37/ArcLayout/master/media/inside_small.png)](https://www.github.com/florent37/ArcLayout)

# KenBurns

Using [https://github.com/flavioarfaria/KenBurnsView](https://github.com/flavioarfaria/KenBurnsView)

[![screen](https://raw.githubusercontent.com/florent37/ArcLayout/master/media/video1.gif)](https://www.github.com/florent37/ArcLayout)

```xml
<com.github.florent37.arclayout.ArcLayout
          android:layout_width="match_parent"
          android:layout_height="200dp"
          app:arc_cropDirection="cropInside"
          app:arc_height="90dp"
          app:arc_padding="30dp"
          >

        <com.flaviofaria.kenburnsview.KenBurnsView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:scaleType="centerCrop"
            android:src="@drawable/road"
            />

        ...

</com.github.florent37.arclayout.ArcLayout>
```

# Download

<a href='https://ko-fi.com/A160LCC' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi1.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>

In your module [![Download](https://api.bintray.com/packages/florent37/maven/ArcLayout/images/download.svg)](https://bintray.com/florent37/maven/ArcLayout/_latestVersion)
```groovy
compile 'com.github.florent37:arclayout:1.0.2'
```

# Inspirations

**Cinema Application by Zsolt Szilvai**

The new Star Wars movie is coming soon, so I decided to design this cinema app screen with one of the Rogue One posters. 
Also, I tried something new: notice, that the white rectangle on the bottom is bended, which makes the design a bit more lively. The app bar has a reduced opacity and the image behind it is blurred to get a unique look. 
I'd appreciate any feedback.

[https://material.uplabs.com/posts/cinema-application-interface](https://material.uplabs.com/posts/cinema-application-interface)

[![screen](https://raw.githubusercontent.com/florent37/ArcLayout/master/media/materialup.png)](https://material.uplabs.com/posts/cinema-application-interface)


# Credits

Author: Florent Champigny [http://www.florentchampigny.com/](http://www.florentchampigny.com/)

<a href="https://play.google.com/store/apps/details?id=com.github.florent37.florent.champigny">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>
<a href="https://plus.google.com/+florentchampigny">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/florent_champ">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://www.linkedin.com/in/florentchampigny">
  <img alt="Follow me on LinkedIn"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/linkedin.png" />
</a>


License
--------

    Copyright 2016 florent37, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
