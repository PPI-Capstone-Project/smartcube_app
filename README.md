<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="https://github.com/PPI-Capstone-Project/smartcube_app/blob/master/screen/app_logo.svg" alt="Logo" width="100" height="100">
  </a>

  <h3 align="center">Best-README-Template</h3>

  <p align="center">
    Smartcube Application
    <br />
    <br />
    <a href="https://drive.google.com/drive/u/1/folders/1m3hS9c6P0lxumXinc5HAL7X440S0v86h">Release app</a>
    ·
    <a  href="mailto:iqbalmaulana172703@gmail.com?subject=Smartcube - ReportBug">Report Bug</a>
    ·
    <a href="mailto:iqbalmaulana172703@gmail.com?subject=Smartcube - Feedback">Feedback</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## Smartcube Application
<div float="left">
  <img src='https://github.com/PPI-Capstone-Project/smartcube_app/blob/dev/screen/Splash%20screen.png?raw=true' width="30%">
  <img src='https://github.com/PPI-Capstone-Project/smartcube_app/blob/dev/screen/detail-server.jpg?raw=true' width="30%">
  <img src='https://github.com/PPI-Capstone-Project/smartcube_app/blob/dev/screen/login.jpg?raw=true' width="30%">
</div>
Smartcube application is security application that can identify fires early, Its combined with smartcube-cli and powered by Artificial Intelligence to detect fires from cameras and sensors

### Build with
* Kotlin
* Jetpack compose

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started
### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* graddle version 8.2.0
* Android studio latest (Giraffe)
* JAVA 17
* minSdk = 30
* targetSdk = 33
* compileSdk = 34

### How to setup project
1. Pull this project to your local devices
2. Import Project to android studio stable
3. Add environtment variable at Local.properties file
  ```
  API_URL=https://smartcube-api-stg-sa6pbxqxca-de.a.run.app/
  WEATHER_API_KEY=
  WEATHER_API_URL=https://api.weatherapi.com/v1/
  MQTT_SERVER_HOST=f1096f5d.ala.asia-southeast1.emqxsl.com
  MQTT_SERVER_PORT=8883
  MQTT_CA_CERT="./mqtt-ssl.crt"
  MQTT_USERNAME=
  MQTT_PASSWORD=
  MQTT_TOPIC=python/mqttSmartCupe
  MQTT_TOPIC2=smartcube/receivecmd
```
4. Setup firebase FCM and add google-services.json in app folder
6. Run the project



<!-- CONTACT -->
## Contact

Your Name - [@twitter_handle](https://twitter.com/twitter_handle) - iqbalmaulana172703@gmail.com@gmail.com

Project Link: [https://github.com/PPI-Capstone-Project/smartcube_app](https://github.com/PPI-Capstone-Project/smartcube_app)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Testing
Unit Test using JUnit4 = https://junit.org/junit4

UI Test using maestro = https://maestro.mobile.dev
