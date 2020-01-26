# AnimatedNumberedTextView
[![](https://jitpack.io/v/MahmoudMabrok/AnimatedNumberedTextView.svg)](https://jitpack.io/#MahmoudMabrok/AnimatedNumberedTextView) [![HitCount](http://hits.dwyl.io/MahmoudMabrok/AnimatedNumberedTextView.svg)](http://hits.dwyl.io/MahmoudMabrok/AnimatedNumberedTextView)

animated textview that animate its value.

# Feature 
- add Message to be displayed with numbere.
- animate from start to specified value (final value become base for next operation).
- update currentValue with amount. 

# Todo 
- [x] add Message with Number.
- [x] allow to update by amount.
- [ ] add Level Indicator.
- [ ] add new UI for TextView.
- [ ] add Indicator for update (anim or floating text)
- [ ] make it as Extension with Kotlin 


# Getting Started
- Add dependency as below 
- Add `xml`
  ``` xml 
  <views.mahmoudmabrok.animatedtextview.AnimatedNumberedTextView
          android:id="@+id/tvScoreForm"
          android:layout_width="match_parent"
          android:layout_height="wrap_content" />
  ```
- get a reference using `findViewById` or using `ButterKnife`. 
- animate from start to specified value using `animateTo`
  ``` kotlin 
  tvScoreForm.animateTo(score, 500)
  ```

- if you want to add **message** to number use `setMessage(msg)`
  ``` kotlin 
  tvScoreForm.setMessage("Score:: ")
  ```

- if you want to animate by a value from currentValue for ex from 10 **by 12**. 
  ``` kotlin 
  tvScoreForm.updateValue(12,1000)
  ```


# How to Add to your project 
- Add it in your root build.gradle at the end of repositories:
  ```
    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
  ``` 
- Add the dependency
  ```
  dependencies {
            implementation 'com.github.MahmoudMabrok:AnimatedNumberedTextView:Tag'
    }
  ```
  - NOTE replace TAG with latest version.  
