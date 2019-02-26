# unitylib

A library to use unity3D as a view in Android

## Getting Started

This repository includes a sample. Clone it to check how unity can easily be a sample view without the need of UnityActivity

### Prerequisites

  - Android Project
  - Unity Project



### Installing

  1. Export your android project from Unity
  2. Copy unity-classes.jar to libs under unitylib
  3. Copy and replace the folders assets and jniLibs under src 
  4. Import unitylib to your android project as a module 

Now Unity lib is ready to be used !


## Code

To use unity as a view, go to your xml file and add this code 

```xml
<com.mc.unitylib.UnityView
        android:id="@+id/custom_unity_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </com.mc.unitylib.UnityView>
```

Then, all you have to do to start unity is : 

```java
    private UnityView unityView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unityView =  findViewById(R.id.custom_unity_view);
        unityView.start();
    }

```

## Authors

* **Majdi Chaabene** - *Check my [website](https://majdichaabene.com) for the work I did

## License

This project is licensed under the MIT License

