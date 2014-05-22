FractionalSizeView
==================
FractionalSizeView is a simple Android View that allows children of
a RelativeLayout to be arranged using ratios, similar to the 
```layout_weight``` property of a ```LinearLayout```. The FractionalSizeView
acts as a strut, allowing other views to be aligned to it.

Inspired by [this](http://stackoverflow.com/a/16412532/2703892) answer on
Stack Overflow, by Ivan Volosyuk.

Setup
-----
There is a sample app provided, although it is best viewed in the layout preview window.
The instructions below are to include the library in your own project.

Clone the repository:  
```git clone git@github.com:Ter0/FractionalSizeView.git```

Import the ```lib``` module into your current project. In Android Studio 0.5.8, this can be achieved
by navigating to ```File > Import Module```, and selecting the folder named ```lib``` in the downloaded project.

Add the newly imported ```lib``` module as a dependency on the module you wish to use it in. In 
Android Studio 0.5.8, this can be achieved by right clicking on the module name, and selecting
```Open Module Settings```. Then select the ```Dependencies``` tab, click the small green '+' symbol
on the right, choose the ```Module Dependency``` entry, and finally choose the ```lib``` module from the
list.

Rebuild the project.

Usage
-----
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <net.ter0.fractionalsizeview.FractionalSizeView
            android:id="@+id/fractional_size_view_horizontal"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:fractionalSize="1/3"
            app:orientation="horizontal" />

        <View
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/right_view"
            android:background="#ffab6a83"
            android:layout_below="@+id/fractional_size_view_horizontal"
            android:layout_alignParentLeft="true"
            android:layout_alignParentStart="true"
            android:layout_alignRight="@+id/fractional_size_view_horizontal"
            android:layout_alignEnd="@+id/fractional_size_view_horizontal" />
    </RelativeLayout>

In this example, the strut occupies a third of the parents width, and the coloured view is aligned to its width.

![Nexus 5](http://i.imgur.com/H3TY4dT.png)

Don't forget to include the namespace in the root element of the layout: ```xmlns:app="http://schemas.android.com/apk/res-auto"```

You can then add the custom attributes to the ```FractionalSizeView```.

| Attribute          | Definition                                  | Possible values                         | Default    |
| ------------------ | ------------------------------------------- | --------------------------------------- | ---------- |
| app:orientation    | The orientation of the strut                | vertical, horizontal                    | horizontal |
| app:fractionalSize | The fraction of the parents width or height to occupy | any valid fraction, eg. 1/2, 2/3, 33/67 | 1/1        |

License
-----
    Copyright 2014 Chris Johns

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
