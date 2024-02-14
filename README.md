# Assignment 1: Amazing Products

An Android application that allows the user to log in to view a list of equipment and food products.

### GitHub Link

The GitHub link for this project is https://github.com/sam-schu/cs4520-assignment1.

### Getting Started

To run the project, simply open it in Android Studio, choose a device to emulate (this project was
tested primarily with an emulated Pixel 5), and press the Run button at the top of the window. The
UI components in the app, as well as the device's back button, can be used for navigation.

### Project Overview

This is a single-activity application with two fragments. When the user first opens the app, the
login fragment is displayed; they must enter the correct username and password and press the
"Login" button to move to the second fragment. The second fragment uses a RecyclerView to display
a scrollable list of equipment and food products. Equipment products are shown in red, and food
products are shown in yellow.

### Project Structure

The source code for the project is divided into two packages under the com.cs4520.assignment1
package: logic and ui. The logic package contains the Authenticator class needed to manage business
logic for the login fragment, and the Products file with classes for managing the list of products
stored. The ui package contains classes for each activity and fragment in the application, as well
as the RecyclerViewAdapter needed to display the products in the product list fragment. The
com.cs4520.assignment1 package also includes the Dataset file that holds information about all
products to be displayed as a 2-dimensional list. Images and layout XML files used by the project
can be found in the project's res folder.