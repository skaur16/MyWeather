
# MyWeather

A weather update application, which takes the location as input and provides the data such as temperature, description, humidity and windspeed, along with icon display as output.
The application makes use of RESTful API, along with Retrofit library to execute the task. Also, as a part of better UX, a progress indicator has been used efficiently. 


## Screenshots

<img src="app/src/main/java/com/example/MyWeather/images/ss1.png" width="200" alt="Launch Screen">
<img src="app/src/main/java/com/example/MyWeather/images/ss2.png" width="200" alt="Result Screen">





## Features

-Textfield with Placeholder text City, Country indicating the required format of location, outlined as location.
-On Clicking the Show Location Button, while the network request collects data, a circular progress indicator is visible in place of button text, disabling the button usage and providing feedback to user.
-On obtaining the data, a card is shown to the users, including all the data in an attractive way.


## Tech Stack

**Business Logic :** Kotlin

**UI Designing:** Jetpack Compose

**Design Pattern:** MVVM



## Lessons Learned

-Retrofit usage
-GeoCoder usage
-Live Data display

