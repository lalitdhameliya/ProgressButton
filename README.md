# ProgressButton
Progress button is the library which will provide you the different kind of button with progress bar in it.

## How to add the library

```
implementation 'com.lalitdhameliya:progressbutton:1.0.0'
```
### Add buttons to your screen
```
<com.lalitdhameliya.progressbutton.ProgressButton
        android:id="@+id/testing_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:text="Test"
        app:textColor="@color/colorAccent" />

<com.lalitdhameliya.progressbutton.ProgressImageButton
    android:id="@+id/test"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:imageProgressTint="@color/colorAccent"
    app:src="@android:drawable/btn_dialog" />
```
## Screen Capture
![alt text](https://github.com/lalitdhameliya/ProgressButton/blob/master/screen-capture.gif)
