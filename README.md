# Fitch Station App
A simple routing android application showing the data from 
[finch_station.json](https://myttc.ca/finch_station.json)

# Objective
- App must be developed natively, use third-party libraries for this assignment
- Show routes for Finch Station.
- Easy to use UI.
- Detailed view of a route should include all details

# Structure
- Application used MVVM (Model View ViewModel) architecture which is the Google recommendation for android developers, This architecture totally separate the View layer to business logic layer that makes things easy to maintain. I also used [jetpack](https://developer.android.com/jetpack)libraries like Room for database, Livedata, NavigationComponents for easy fragment navigation, I also used DaggerHilt to manage app dependencies.Retrofit for rest api. Epoxy for building complex screens in a RecyclerView, Lottie for loading animation

# MVVM structure graph


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
