# App Builders 2022 - Modern Android Techniques

This app is the sample project used for the Modern Android Techniques workshop 
at App Builders 2022. It is a weather app called Shine, built using the latest Android
technologies.

# Your Mission

You are a newly hired Android Engineer, starting out at Sunshine Inc. A new startup
looking to disrupt the weather forecasting industry.

You've been tasked with building the 1st iteration of Shine, the Android app for Sunshine to show off their weather forecasting abilities. 
As a cutting edge engineer, you'd like to build the app using the latest technologies.

The product designers at Sunshine have provided the following [design](https://miro.com/app/board/uXjVO8Ww9Es=/?share_link_id=773086494141)

The **main screen** shows the weather at locations a user has selected. Tapping on a location opens a detail screen, showing detailed weather information about the location.
The screen also has a menu item in the toolbar, tapping it opens the **detail screen**.  

The **location screen** shows a list of locations a user can select from. When the user taps a location it's id is cached within the app and used to acquire the weather for the location.
The weather for the location is shown on the **main screen** and **detail screen**.

The **detail screen** shows detailed weather information about the location.

Build the app and make Sunshine Inc proud!

# Step 1 - Create the Project

Create the project in Android Studio, making sure to call the app name **Shine**.

As an app using the latest technologies, you should setup the project using the **Empty Compose Activity** template.

You may find the following [web page](https://developer.android.com/jetpack/compose/setup) useful.

# Step 2 - Create the Main Screen

Using the [design](https://miro.com/app/board/uXjVO8Ww9Es=/?share_link_id=773086494141), create the main screen using Jetpack Compose.

You may find these web pages useful:

- [Jetpack Compose Tutorial](https://developer.android.com/jetpack/compose/tutorial)
- [Modifiers](https://developer.android.com/jetpack/compose/modifiers)

# Step 3 - Building up the domain / data layer

By this point you should have a screen similar to the main screen design.

Next, you need to be able to populate the app with data.

Create a ViewModel for the Main Screen, along with a repository and data source to receive weather data.

You can make a request to this [URL](http://darrylbayliss.net/sunshine/weather.json) to get weather data into the app.

You may find these web pages useful:

- [App Architecture](https://developer.android.com/topic/architecture)
- [Coroutines in Android](https://developer.android.com/kotlin/coroutines)
- [Retrofit](https://square.github.io/retrofit/)
- [Ktor](https://ktor.io/)

# Step 4 - Create the Location Screen

Adding the location screen will allow you to show the weather for specific locations.

Using the repository and data source you created in step 3, query the endpoint to get all locations and show them on the screen.

Show the locations in a list, allowing each one to be selected.

Selecting a location should cache the location id to the app and return to the main screen.

You may find these web pages useful:

- [Jetpack Datastore](https://developer.android.com/topic/libraries/architecture/datastore)

# Step 5 - Hook the main screen and location screen together

Now the main screen and location screen are built. It's time to allow navigation between the two.

Add a way for navigation to occur between screens.

You may find these web pages useful:

- [Jetpack Navigation](https://developer.android.com/guide/navigation)
- [Navigation for Compose](https://developer.android.com/jetpack/compose/navigation)

# Step 6 - Using the location id on the Main Screen

Once the location id saved to the app, the id should be used to know what locations to show on the main screen.

Update the business logic of the main screen, so it only shows locations for ids saved to the app.

# Step 6 - Add a menu item to the Main Screen toolbar



