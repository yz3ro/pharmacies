# Pharmacy Finder App

This Kotlin-based Android application is a mobile app that fetches nearby pharmacies based on the user's location and displays them. It also provides the functionality to show the selected pharmacy's location on Google Maps for navigation.

## Features

- User Authentication: Allows users to sign in to the application.
- Location Permission: Requests permission from the user to fetch their device location.
- Pharmacy Listing: Displays a list of nearby pharmacies based on the user's location.
- Google Maps Integration: Shows the selected pharmacy's location on Google Maps and provides navigation directions.

## Technologies Used

- MVVM Architecture: Utilizes the Model-View-ViewModel architecture for managing data and separating UI concerns.
- LiveData: Used for updating data flow and UI updates.
- Dependency Injection: Dagger Hilt library is employed for dependency injection and managing app components.
- Retrofit API: Fetches pharmacy data and location information from the server.
- Google Maps API: Integrates with Google Maps API to display pharmacy locations and provide navigation.

## Installation

1.git clone https://github.com/user/pharmacy-finder.git

2.Open Android Studio and import the project files.

3.Build and run the project.

## Usage
1.Launch the application and sign in.

2.Location permission will be requested.

3.Once location permission is granted, nearby pharmacies will be listed.

4.Select a pharmacy.

5.The selected pharmacy's location will be displayed on Google Maps, providing navigation directions.

## Contributions
- Contributions and feedback are welcome. Feel free to contribute by opening an Issue or sending a Pull Request.

## Screenshots

![Screenshot](screens/home.png)
![Screenshot](screens/pharmacies.png)

