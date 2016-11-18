# ArcLayout

With Arc Layout explore new styles and approaches on material design

# Usage

```xml
<com.github.florent37.arclayout.ArcLayout
         android:layout_width="match_parent"
         android:layout_height="200dp"
         app:arc_cropDirection="cropOutside|cropInside"
         app:arc_height="90dp"
         app:arc_padding="30dp"
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
          >
 
          <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:scaleType="centerCrop"
                android:src="@drawable/road" /> 
                
 </com.github.florent37.arclayout.ArcLayout>        
```

## Crop Inside

```xml
<com.github.florent37.arclayout.ArcLayout
          android:layout_width="match_parent"
          android:layout_height="200dp"
          app:arc_cropDirection="cropInside"
          app:arc_height="90dp"
          app:arc_padding="30dp"
          >
 
          <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:scaleType="centerCrop"
                android:src="@drawable/road" /> 
                
 </com.github.florent37.arclayout.ArcLayout>        
```

# KenBurns

Using [https://github.com/flavioarfaria/KenBurnsView](https://github.com/flavioarfaria/KenBurnsView)

[![screen](https://raw.githubusercontent.com/florent37/DiagonalLayout/master/media/sample.gif)](https://www.github.com/florent37/DiagonalLayout)

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

#Download

In your module [![Download](https://api.bintray.com/packages/florent37/maven/ArcLayout/images/download.svg)](https://bintray.com/florent37/maven/ArcLayout/_latestVersion)
```groovy
compile 'com.github.florent37:arclayout:1.0.0'
```

#Credits

Author: Florent Champigny [http://www.florentchampigny.com/](http://www.florentchampigny.com/)

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
