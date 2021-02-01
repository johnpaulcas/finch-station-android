# Fitch Station App
A simple routing android application showing the data from 
[finch_station.json](https://myttc.ca/finch_station.json)

Dowload the app [here](https://drive.google.com/file/d/1C3SMPdQ0VkZHp83V0hb_JuNStUM6X1O_/view?usp=sharing)!

# Objective
- App must be developed natively, use third-party libraries for this assignment
- Show routes for Finch Station.
- Easy to use UI.
- Detailed view of a route should include all details

# Structure
- Application used MVVM (Model View ViewModel) architecture which is the Google recommendation for android developers, This architecture totally separate the View layer to business logic layer that makes things easy to maintain. I also used [jetpack](https://developer.android.com/jetpack) libraries like Room for database, Livedata, NavigationComponents for easy fragment navigation, I also used DaggerHilt to manage app dependencies.Retrofit for rest api. Epoxy for building complex screens in a RecyclerView, Lottie for loading animation

# MVVM architecture
Diagram shows how all the modules should interact with one another after designing the app

Each component depends only on the component one level below it. For example, activities and fragments depend only on a view model. The repository is the only class that depends on multiple other classes; The repository depends on a persistent data model and a remote backend data source.

This design creates a consistent and pleasant user experience. Regardless of whether the user comes back to the app several minutes after they've last closed it or several days later, they instantly see the information that the app persists locally. If this data is stale, the app's repository module starts updating the data in the background.
![MVVM](https://github.com/johnpaulcas/finch-station-android/blob/main/screenshots/mvvm.png) 

# Overview API call and app caching
This is base on google recommended architecture, more reading and reference can be found [here](https://developer.android.com/jetpack/guide#addendum)
![MVVM](https://github.com/johnpaulcas/finch-station-android/blob/main/screenshots/networkbounce.png) 

# Screenshots
### Home/FinchStation Stops
![Home](https://github.com/johnpaulcas/finch-station-android/blob/main/screenshots/1.jpg) 
### FinchStation Stop Routes
![Routes](https://github.com/johnpaulcas/finch-station-android/blob/main/screenshots/2.jpg) 
### FinchStation Stop No Route/s
![EmptyRoutes](https://github.com/johnpaulcas/finch-station-android/blob/main/screenshots/1.jpg) 
### FinchStation RouteTimeStop
![RouteTimeStop](https://github.com/johnpaulcas/finch-station-android/blob/main/screenshots/1.jpg) 

# Resource/s
- https://developer.android.com/jetpack
- https://developer.android.com/jetpack/guide#addendum
- https://github.com/airbnb/epoxy
- https://square.github.io/retrofit/
- https://github.com/JakeWharton/timber
- https://developer.android.com/topic/libraries/view-binding
- https://dagger.dev/hilt/
- https://lottiefiles.com/
- https://github.com/airbnb/lottie-android
- https://github.com/airbnb/epoxy
- https://lottiefiles.com/
